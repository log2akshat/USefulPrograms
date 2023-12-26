# Installation and Project Creation

1. Download and extract the archive of Go into `/usr/local`, creating a fresh Go tree in `/usr/local/go`:
    ```bash
    $ sudo tar -C /usr/local -xzf go1.21.5.linux-amd64.tar.gz
    ```

2. Add `/usr/local/go/bin` to the PATH environment variable in `.bashrc` or `/etc/profile` (for a system-wide installation):
    ```bash
    export PATH=$PATH:/usr/local/go/bin
    ```

3. Verify that you've installed Go by opening a command prompt and typing the following command:
    ```bash
    $ go version
    ```

4. Confirm that the command prints the installed version of Go.

5. Create a new Go application by running the following command:
    ```bash
    $ go mod init booking-app
    ```

6. For running the Go application, execute the following command:
    ```bash
    $ go run main.go
    ```

    If it contains multiple modules, you can include the name of the module after `main.go`:
    ```bash
    $ go run main.go helper.go
    ```

