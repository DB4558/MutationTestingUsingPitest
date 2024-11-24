

# Mutation Testing on Data Structure Algorithms using PITEST
##Contributors
[![All Contributors](https://github.com/ketki-kerkar)](#contributors)


This project demonstrates **Mutation Testing** on various **Data Structure Algorithms** using [PITEST](https://pitest.org/), a leading mutation testing framework for Java. The algorithms are tested with **JUnit** test cases to ensure code reliability and mutation coverage.

---

## 📚 Table of Contents
1. [Introduction](#introduction)
2. [Project Structure](#project-structure)
3. [Technologies Used](#technologies-used)
4. [Setup Instructions](#setup-instructions)
5. [Running Tests](#running-tests)
6. [Mutation Testing](#mutation-testing)
7. [Contributors](#contributors)

---

## 🧠 Introduction

Mutation testing helps evaluate the quality of test cases by introducing small changes (mutations) in the source code and verifying if the tests can catch these mutations. This project applies mutation testing to common data structure algorithms such as:
- Sorting (Quick Sort, Merge Sort)
- Searching (Binary Search)
- Linked List Operations
- Tree Traversals

The testing framework **PITEST** is used to perform mutation analysis on these algorithms.

---


---

## 🛠️ Technologies Used

- **Java**: Programming language
- **JUnit 5**: Unit testing framework
- **PITEST**: Mutation testing framework
- **Maven**: Build automation tool

---

## 🚀 Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-repo-name.git
   cd your-repo-name
2. **Install Dependencies Ensure Maven is installed, then run:**
   ```bash
   mvn clean install
3. **Configure PITEST Ensure the following plugin configuration is present in the pom.xml:**
     <plugin>
    <groupId>org.pitest</groupId>
    <artifactId>pitest-maven</artifactId>
    <version>1.9.11</version>
    <executions>
        <execution>
            <goals>
                <goal>mutationCoverage</goal>
            </goals>
        </execution>
    </executions>
</plugin>
## Mutation Testing
mvn org.pitest:pitest-maven:mutationCoverage


## Running Tests

   ** Run the JUnit tests to ensure all algorithms work as expected:**
  ```bash
     mvn test


    ```


