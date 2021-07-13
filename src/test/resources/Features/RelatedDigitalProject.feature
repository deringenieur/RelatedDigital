Feature: Related Digital Case Study
 
 Scenario: Login
 
    #New User
    
    Given Initialize the browser
    And User navigate to "https://euromsgexpress.com/" website
    And User clicks to "//a[text()='GİRİŞ']" element
    Then User waits
    And User enters "furkanguler.eem@gmail.com" text in "#exampleInputEmail1" textbox
    And User enters "Test2021" text in "#exampleInputPassword1" textbox
    Then User waits 
    And User clicks to "//button[@type='submit']" element
    Then Verify element present with "//b[text()='Üye Ekle']" 
    And User clicks to "//b[text()='Üye Ekle']" element
    And User clicks to ".btn.btn-labeled.btn-purple" element
    And User enters "Test" text in "//input[@placeholder='Listeye isim ver']" textbox
    And User clicks to ".fa.fa-save" element
    And User clicks to "//*[text()=' Üye Ekle']" element
    And User clicks to "//a[text()='Form ile Ekle']" element
    And User enters "Furkan" text in "//input[@id='firstName']" textbox
    And User enters "Guler" text in "//input[@id='lastName']" textbox
    And User enters "furkanguler.eem@gmail.com" text in "//input[@id='email']" textbox
    And User clicks to "//*[text()=' Eklediğim üyelerin iletişim izni olduğunu onaylıyorum. ']" element
    And User clicks to "//*[text()=' Kaydet ']" element
    Then User gets text from "//tr[@class='ng-star-inserted']/td[1]" and verifies it
    
    
    #User Details
    
    And User clicks to "//*[text()='Ana Sayfa']" element
    And User clicks to "//b[text()='Üye Ekle']" element
    And User clicks to ".btn.btn-sm.btn-primary" element
    And User clicks to "//*[text()=' Üye Ekle']" element
    And User clicks to "//a[text()='Dosyadan Yükle']" element
    Then User uploads the file to "//*[text()=' Dosya seçiniz. ']"
    And User clicks to "//*[text()='Eklediğim üyelerin iletişim izni olduğunu onaylıyorum. ']" element
    And User clicks to "//*[text()=' Dosyayı Yükle ']" element
    Then Verify element present with "//*[text()='Dosya gönderildi!']"
    Then User closes the browser
    
    
    
    
    
    
    
   
    
    
      