const {Builder, By, until } = require('selenium-webdriver');

async function googleTest() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await driver.get('https://google.com');

        let rejectAll = await driver.findElement(By.xpath("//*[text()='Reject all']"));

        await rejectAll.click();

        let searchText = 'Selenium Webdriver';

        let option = 'Videos'

        let index = 3;

        await driver.findElement(By.name("q")).sendKeys(searchText);

        let nthOption = await driver.wait(until.elementLocated(By.xpath(`//ul[@role[contains(., 'listbox')]]/li[${index}]`), 30));

        await nthOption.click();

        let searchBox = await driver.findElement(By.name("q"))

        await searchBox.clear()
        
        await searchBox.sendKeys(searchText)

        nthOption = await driver.wait(until.elementLocated(By.xpath(`//ul[@role[contains(., 'listbox')]]/li[${index}]`), 30));

        await nthOption.click()

        let navigation = await driver.wait(until.elementLocated(By.xpath(`//div[@role='navigation']//a[@role='link']//*[text()=${option}]`), 30));

        await navigation.click()

        let resultStats = await driver.findElement(By.xpath("//*[@id='result-stats']"));

        console.log(await resultStats.getText());

        await driver.quit();

    } catch (error) {
        console.error('An error happening during the execution of the script ', error);
        await driver.quit();
    }
}

googleTest();
