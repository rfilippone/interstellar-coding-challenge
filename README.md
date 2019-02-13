# interstellar-coding-challenge
Coding challenge for interstellar. Image generation service

## Prerequisite

The app is based on GDAL for the image processing part, so you will need that installed on the machine where you intend to run the app.
If installing GDAL is not possible then the secondary dependency is to have Docker installed and working on the machine where you intend to run the app.

## Data Setup

The data from the bucket in the challenge must be extracted in the `data/` folder

## How to run the app

There are 2 ways:

1. You have GDAL installed. Run `./gradlew bootrun` at the root of the project

2. You don't have GDAL installed but you have Docker installed: Run the provided run script with `./run.sh` at the root of the project. (During the first run this operation will take some time to build the Docker image and dowload all the needed dependencies)
