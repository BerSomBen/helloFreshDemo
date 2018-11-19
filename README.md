# Hellofresh Challenge Automate http://automationpractice.com

This page pattern selenium application shell provide 3 Testcases for
automationpractice.com 
1. Register a new user
2. Login a registered user
3. Checkout a product
 
## Why page pattern?

I used the page pattern in the past, to test about 5 different shop frontends, all on the same backend technology.
With page pattern, I was able to think of what tests I wanna write and was able to create them abstract without to 
know anything about the frontend at all. When a new frontend comes into process, I was able to glue the frontend 
onto the framework and link them to the tests. 
 
## Dependencies

This solution is build in java, to run, you need at least a jre 1.8, since I use maven,
you will need a jdk 1.8 and the latest maven in the path. 
The test are able to be run eigther in chrome or in firefox. Therefore, you need the latest browser 
installed on your machine.

## How to run

Just clone the repo, run 
	```
	maven clean build
	maven test
	```
done. 
Chromedriver, firefoxdriver, majonette etc are done via webdrivermanager from bonigarcia. probs to him. 


## Open Points and ToDos
- Pagepattern in js is using some antipatterns, e.g. direct access towards member variables, unsafe Type parameters, lots of unimplemented methods.... 
I refactored most of them, but some still need to be changed to getters. 

## Bugs
1. In Firefox Cart-Link does not lead to cart. You must hover, then click other link. 
- I think that's a bug on prestashop itself. So I leave my checkout test failing. 

## More Tests
To really test the site, with that framework, you have the possibibilty to populate tests for edge cases 
to verify the shop is working. e.g customer with minimal requeried data. Or create failing tests, to check,
if e.g. wrong written mail, is warned proberbly. 
