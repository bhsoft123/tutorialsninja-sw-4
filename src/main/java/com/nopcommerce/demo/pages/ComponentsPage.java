package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ComponentsPage extends Utility {

    By components = By.xpath("//h2[contains(text(),'Components')]");


    public String getActualText() {
        return getTextFromElement(components);
    }
}