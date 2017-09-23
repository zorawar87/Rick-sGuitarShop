# Rick’s inventory #

## CORE MISSION: Finding the perfect instrument for his customers ##

### About Rick ###
 * has been selling guitars for many years
 * expert in guitars
 * specialises in finding the perfect instrument for his customers
 * all his guitars made the list of top 10 guitar brands in the world 


### Current System ###
 * paper-based guitar inventory system
 * keeps a list of all guitars in stock {what happens to guitars out-of-stock?}
 * For each guitar keeps track of 7 properties (below)
 * Meets a new customer, gets to know their needs through a friendly conversation about their prefs and experience. Then consults the list.

### Expectations ###
 * _Computer inventory program with a search tool_ to help him match up a customer to his dream instrument
 * could hire someone to help him manage the inventory
 * adding, removing and modifying entries should be his new fav task
 * anxious to test a version that allows him to:
    * use the new search tool, and 
    * manage the inventory asap.

### Candidate Objects ###
* Guitar 
  * keeps a list of all guitars in stock
  * for each guitar, keeps track of
    1. s/n
    2. price
    3. brand = Gibson|Fender|Ibanez|Paul_Reed_Smith|Epiphone|Jackson|Taylor|Martin|Yamaha|Rickenbacker
    4. model
    5. type = Acoustic|Electric
    6. type of top wood = Rosewood|Alder|Mahogany|Cedar
    7. type of back wood = Rosewood|Alder|Mahogany|Cedar
* Customer
* Transaction

### Suggestion ###
1. When meeting a new customer, get to know their:
  * customer’s preferences, and
  * musical experience.
2. Consult the list
* add, remove and modify guitar entries


### Testing ###
- [ ] Create a Class called GuitarTester,
- [ ] in main() include appropriate tests to test the core functionality of the program
each test should include appropriate print statements to understand the test and the outcome of the test once your program is run.





