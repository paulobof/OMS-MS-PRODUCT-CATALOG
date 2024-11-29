package br.com.paulobof.productcatalog.application.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

    @Configuration
    public class BatchJobRunner {

        @Autowired
        private JobLauncher jobLauncher;

        @Autowired
        private Job jobProduct;

        @Bean
        public ApplicationRunner runJob() {
            return args -> {
                ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                scheduler.schedule(() -> {
                    try {
                        jobLauncher.run(jobProduct, new JobParametersBuilder()
                                .addLong("startAt", System.currentTimeMillis())
                                .toJobParameters());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, 10, TimeUnit.SECONDS);
            };
        }
    }


