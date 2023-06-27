# is anagram tool

CLI Java application that checks if two texts are anagrams of each other.

> An _anagram_ is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


## How to use

### Build 
`maven` build tool is used for managing the lifecycle of the application. simply run the following command to build the project.

```bash 
mvn clean package
```

After successful build, `./target/is-anagram.jar` file will be created. 

### Run

Use the application from your terminal providing two texts as arguments.

```bash
java -jar is-anagram.jar 'help' 'pleh'
```

The result of the anagram check will be displayed on the terminal.

### Test

`junit5` is used for testing the application. simply run the following command to execute all the tests.

```bash
mvn clean test
```
