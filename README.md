# product-test-service
Is a mock of the real product-service application that is made for simplified testing.
## Behaviour
Should run in the Google Cloud and randomly publishes Pub/Sub messages about the Product and Option entities in separate channels.
## Docker setup
Uses a dockerized version of PostgreSQL.
### Run fresh
Initializes a fresh PostgreSQL database.
### Run normally
Continues the PostgreSQL database with data from `./postgres-data`.
