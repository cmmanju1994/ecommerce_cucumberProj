Feature:Product details

Scenario:Verify all products and product details page

Given user navigates to home page
When user Click on Products button
Then user navigated to ALL PRODUCTS page successfully
And The products list is visible
When user Click on View Product of first product
Then User is landed to product detail page
And all product detail is visible: product name, category, price, availability, condition, brand
