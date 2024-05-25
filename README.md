# Втора лабораториска вежба по Софтверско инженерство
## Давид Митоски 213221

2. ## CFG Graph
![graph](https://github.com/DavidMitoski/SI_2024_lab2_213221/assets/165181489/38e0ca17-31b1-451b-9932-d67582c8374a)




3. ## Цикломатската комплексност е 10, ја пресметав по формулата Р+1 каде што Р во мојот случај е 9 , односно има 9 предикатни јазли па 9+1=10
4. ## Тест случаи според Every Branch
   Тест случај 1: allItems е null

Input: allItems = null, payment = 100
Expected Output: Исклучок: "allItems list can't be null!"

Тест случај 2: item.getName() е null или празно

Input: allItems = [new Item(null, "123456", 100, 0.1f)], payment = 100
Expected Output: true (името на предметот се поставува на "unknown")

Тест случај 3: item.getBarcode е null

Input: allItems = [new Item("Item1", null, 100, 0.1f)], payment = 100
Expected Output: Исклучок: "No barcode!"

Тест случај 4: item.getBarcode има невалидни карактери

Input: allItems = [new Item("Item1", "1234a6", 100, 0.1f)], payment = 100
Expected Output: Исклучок: "Invalid character in item barcode!"

Тест случај 5: item.getDiscount е поголем од 0

Input: allItems = [new Item("Item1", "123456", 100, 0.1f)], payment = 100
Expected Output: true (сумата со попуст е 90)

Тест случај 6: item.getDiscount е 0 или помалку

Input: allItems = [new Item("Item1", "123456", 100, 0)], payment = 100
Expected Output: true (сумата е 100)

Тест случај 7: item.getPrice е поголем од 300, item.getDiscount е поголем од 0 и првиот карактер на баркодот е '0'

Input: allItems = [new Item("Item1", "0123456", 400, 0.1f)], payment = 400
Expected Output: true (сумата со попуст и намалување е 360)

Тест случај 8: sum е помала или еднаква на payment

Input: allItems = [new Item("Item1", "123456", 100, 0.1f)], payment = 90
Expected Output: true (сумата е 90)

Тест случај 9: sum е поголема од payment

Input: allItems = [new Item("Item1", "123456", 100, 0.1f)], payment = 80
Expected Output: false (сумата е 90)
![tabela](https://github.com/DavidMitoski/SI_2024_lab2_213221/assets/165181489/fd83e622-cb1b-4541-aee4-9d137f507162)


5. ## Тест случаи според Multiple Condition
(https://github.com/DavidMitoski/SI_2024_lab2_213221/assets/165181489/edb98850-20f5-4794-92a1-be2fff01e42d)

Тест случај 1: Цената е поголема од 300, попустот е поголем од 0, баркодот почнува со '0'

Input: allItems = [new Item("Item1", "0123456", 400, 0.1f)], payment = 370
Expected Output: true (Сумата со попуст и намалување е 370)


Тест случај 2: Цената е поголема од 300, попустот е поголем од 0, баркодот не почнува со '0'

Input: allItems = [new Item("Item1", "1123456", 400, 0.1f)], payment = 360
Expected Output: false (Сумата со попуст е 360, но без намалување)

Тест случај 3: Цената е поголема од 300, попустот е 0 или помал, баркодот почнува со '0'

Input: allItems = [new Item("Item1", "0123456", 400, 0.0f)], payment = 400
Expected Output: false (Сумата е 400, без попуст и без намалување)

Тест случај 4: Цената е поголема од 300, попустот е 0 или помал, баркодот не почнува со '0'

Input: allItems = [new Item("Item1", "1123456", 400, 0.0f)], payment = 400
Expected Output: false (Сумата е 400, без попуст и без намалување)

Тест случај 5: Цената е 300 или помалку, попустот е поголем од 0, баркодот почнува со '0'

Input: allItems = [new Item("Item1", "0123456", 300, 0.1f)], payment = 270
Expected Output: false (Сумата со попуст е 270, но без намалување бидејќи цената не е поголема од 300)

Тест случај 6: Цената е 300 или помалку, попустот е поголем од 0, баркодот не почнува со '0'

Input: allItems = [new Item("Item1", "1123456", 300, 0.1f)], payment = 270
Expected Output: false (Сумата со попуст е 270, без намалување)

Тест случај 7: Цената е 300 или помалку, попустот е 0 или помал, баркодот почнува со '0'

Input: allItems = [new Item("Item1", "0123456", 300, 0.0f)], payment = 300
Expected Output: false (Сумата е 300, без попуст и без намалување)

Тест случај 8: Цената е 300 или помалку, попустот е 0 или помал, баркодот не почнува со '0'

Input: allItems = [new Item("Item1", "1123456", 300, 0.0f)], payment = 300
Expected Output: false (Сумата е 300, без попуст и без намалување)

6. ## Unit тестови
   Unit тестовите ги направив врз база на дадените тест случаи и нацртаниот граф се со цел да ја испитам нивната точност
