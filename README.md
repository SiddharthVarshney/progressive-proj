- Stop mongo service on localhost
  > mongo admin --eval "db.shutdownServer()"
  
- Run Docker image
  > docker run --name some-name -p 27017:27017 -v /some/volume:/data/db -d mongo
  
- Open mongo shell
  > docker exec -it some-name bash \
  > mongo (inside bash)
