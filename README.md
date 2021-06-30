- Stop mongo service on localhost
  > mongo admin --eval "db.shutdownServer()"
  
- Run Docker image
  > docker run --name some-name -p 27017:27017 -v /some/volume:/data/db -d mongo
  
- Open mongo shell
  > docker exec -it some-name bash \
  > mongo (inside bash)


***
***

- Create new docker network
  > docker network create {network-name}

- Connect docker containers to network
  - Can be done while starting container
    > docker run --network={network-name} .....
  - Connect a currently running container to a network
    > docker network connect {network-name} {container-name}

- Get current IP address of containers
  > docker inspect {container-name}

- In the source code, paste the above IP Address inplace of "localhost"
