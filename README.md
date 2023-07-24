## Calculator

It's a command line calculator that can work with following operators:
- `+` - addition
- `-` - subtraction
- `*` - multiplication
- `/` - division
- `( )` - brackets

I decided to not use spaces between operators and operands, so the input should look like this: `1+2*3`.

## How to run

**Requirements**

- Docker. If you don't have it, you can install it from [here](https://docs.docker.com/get-docker/).

### Steps

**1. Clone this repository and navigate to the root project directory.**

```bash
$ git clone https://github.com/Kidchai/Calculator.git
$ cd Calculator
```

**2. Build the Docker image.**

```bash
$ docker build -t calculator .
```

**3. Run the Docker container.**

```bash
$ docker run -it calculator
```

That's it!