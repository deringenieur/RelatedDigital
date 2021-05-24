Feature: Hepsiburada Case Study
 
 Scenario: Shopping with login and without login
 
    #Login
    
    Given Initialize the browser
    And User navigate to "https://hepsiburada.com" website
    When User hoovers the mouse on to "#myAccount"
    And User clicks to "//a[@id='login']" element
    And User enters "furkanguler.eem@gmail.com" text in "//input[@id='txtUserName']" textbox
    And User enters "Test2021" text in "//input[@id='txtPassword']" textbox
    Then User tab to "ENTER"
    Then Verify that user is succesfully logged in with "#myAccount"
    
    #Shopping
    
    And User enters "Airpods" text in "//input[@type='text']" textbox
    Then User tab to "ENTER"
    And User clicks to "//span[contains(text(),'Apple AirPods 2. Nesil Bluetooth Kulaklık MV7N2TU/')]" element
    And User clicks to "(//button[@class='add-to-basket button small'])[1]" element
    And User clicks to ".checkoutui-Modal-2iZXl" element
    And User clicks to "(//button[@class='add-to-basket button small'])[2]" element
    And User clicks to "//button[text()='Sepete git']" element
    Then User gets text from "(//div[@class='merchant_name_1NA4w']/span/a)[1]" element and "(//div[@class='merchant_name_1NA4w']/span/a)[2]" element and compares them
    Then User closes the browser
    
    #Shopping without user login
    
    Given Initialize the browser
    And User navigate to "https://hepsiburada.com" website
    When User hoovers the mouse on to "//span[text()='Kitap, Müzik, Film, Hobi']"
    And User clicks to "//span[text()='Uzaktan Kumandalı Araçlar']" element
    And User clicks to "//span[text()='30A Esc Fırçasız Motor Sürücü']" element
    And User clicks to ".button.big.with-icon" element
    And User clicks to "//span[text()='Sepetim']" element
    Then User validates "//a[text()='30A Esc Fırçasız Motor Sürücü']" product is in the basket
    Then User closes the browser
    
    #Login
    
    Given Initialize the browser
    And User navigate to "https://hepsiburada.com" website
    When User hoovers the mouse on to "#myAccount"
    And User clicks to "//a[@id='login']" element
    And User enters "furkanguler.eem@gmail.com" text in "//input[@id='txtUserName']" textbox
    And User enters "Test2021" text in "//input[@id='txtPassword']" textbox
    Then User tab to "ENTER"
    Then Verify that user is succesfully logged in with "#myAccount"
    
    
    #Delivery Options: Today
    
    And  User navigate to "https://hepsiburada.com" website
    And  User enters "Crocs Crocband Unisex Terlik" text in "//input[@type='text']" textbox
    Then User tab to "ENTER"
    And User clicks to "(//span[text()='Crocs Crocband Unisex Terlik'])[2]" element
    And User clicks to "#addToCart" element
    And User clicks to "//button[text()='Sepete git']" element
    And User clicks to "#continue_step_btn" element
    And User clicks to "//div[text()='Bugün Teslimat']" element 
    
    
    
    #Delivery Options: Tomorrow
    
    And  User navigate to "https://hepsiburada.com" website
    And  User enters "Crocs Crocband Unisex Terlik" text in "//input[@type='text']" textbox
    Then User tab to "ENTER"
    And User clicks to "(//span[text()='Crocs Crocband Unisex Terlik'])[2]" element
    And User clicks to "#addToCart" element
    And User clicks to "//button[text()='Sepete git']" element
    And User clicks to "#continue_step_btn" element
    And User clicks to "//div[text()='Yarın Teslimat']" element
    Then User closes the browser
    
    
      