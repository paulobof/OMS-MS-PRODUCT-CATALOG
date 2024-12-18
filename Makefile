
build:
	mvn compile

unit-test:
	@echo "Running unit tests"
	@mvn test -P unit-test


integration-test:
	mvn test -P integration-test

system-test:
	mvn test -P system-test

performance-test:
	mvn gatling:test -P performance-test

test: unit-test integration-test system-test

package:
	mvn package

docker-build:
	 docker build -t product-catalog:1.0 .

docker-start:
	docker compose -f docker-compose.yaml up -d

docker-stop:
	docker compose down
