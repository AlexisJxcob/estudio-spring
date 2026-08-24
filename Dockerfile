FROM ubuntu:latest
LABEL authors="alexis"

ENTRYPOINT ["top", "-b"]