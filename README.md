# Module unit tests demo

Simple, basic, yet complete example of the ide of unit and integration tests of modularized system.

# What is it about?

This is a part of live coding session of the lecture. 

Slides you can find in the `Automatic tests: You won't find it in a book.pdf` file.

Session recording is here: https://www.youtube.com/watch?v=_7vfW3DpZvU 

# How to navigate branches
 
Watch footers in pdf file with presentation slides. Sometimes the branch name appears in the footer. This is the branch you can checkout to see how the problem mentioned on slide reflects in the source code.

## Branch naming
Branch naming schema is as follows: `<step>/<subject>/<status>`, where:
* `<step>` is the order number of the exercise
* `<subject>` is the description what this example is about
* `<status>` represents if this is the beginning of the implementation (`start`) or is it fully implemented example (`done`)

# How to Run
To run the project use: 
`./gradlew bootRun`

However more important here are tests which can be started with a command:
`./gradlew test`