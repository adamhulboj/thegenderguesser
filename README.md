# The Gender Guesser
Java application that can detect gender


Trello table invitation link - https://trello.com/invite/b/nt4TUcjM/bae4cf3a50873a3dcd67123a7fb33ec5/the-gender-guesser-app
(ideally all tasks will be marked as done ;-) )

I will learn Java doing this little project.

Business requirements:
- we have list of male and feamale tokens 
- should be packaded within JAR
- lists in form of two flat files, each line separate token
- application responds giving gender or inconclusive
- algorithm in two variants 1 - first token is checked, 2 - all tokens are checked
- application expose 2 http endpoints, gender guessing (string)  and returning avaliable tokens for each gender
- gender detection alhorithm type parameter can be passed in any form aka. you can choose witch gener guesser algorithm is executed

Technical requirements:
- use java and jdk >= 11 (will be 16)
- use gradle to provide task that builds JAR that is runnable on its own
- build on top on spring framework
- should be well tested
- should be provided in a form of link to git repository (this repository it is)
- dont load token list into memory
- (optional) algorithm versionable
- (optional) easily runnable through docker
