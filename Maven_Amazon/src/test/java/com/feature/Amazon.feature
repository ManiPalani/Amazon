Feature: E-Commerce Application.
Scenario Outline: Product Search Module.
Given user Can Able To Launch The Amazon URL
When user Can Able To "<Dropdownvalue>" The DropDown Option
And user Can Able To "<Searchvalue>" The Product
Then user Can Purchase the Selected Product

Examples:

|Dropdownvalue|Searchvalue|
|Baby|toys|