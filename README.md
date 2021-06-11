# Base64 online services  [![Build Status](https://github.com/noxone/base64online/actions/workflows/test.yml/badge.svg)](https://github.com/noxone/base64online/actions)

The most useful base64 tools put together on one page.

This page is ment to collect everything you need around base64 and provide an online tool so you can use it whereever and whenever you need it.

## Usage

### Online

Just go to [base64.olafneumann.org](https://base64.olafneumann.org) to use the page online.

### Docker

Run the application local in a [Docker container](https://hub.docker.com/r/noxone/base64online) and then find it on port 80 of your local machine:

````bash
docker run -d -p 80:80 noxone/base64online
````

## Development

### Build

1. Clone the repository
2. Execute ``gradlew clean build`` in the project's root directory
3. Find the output in ``./build/distributions``

### Live Development

For a nice development experience use ``gradlew run --continuous``. So the page will automatically reload for every source file change.

## More ideas

If you ideas for new features, please open an [issue](https://github.com/noxone/base64online/issues).
