sudo rm -rf ./postgres-data
docker-compose down --volumes
sh ./run-postgres.sh
