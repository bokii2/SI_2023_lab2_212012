<h1> Втора лабораториска вежба по Софтверско инженерство </h1>
<h2> Бојан Поповски, 212012 </h2>
<h3> Control Flow Graph <h3>
  
  ![image](https://github.com/bokii2/SI_2023_lab2_212012/assets/109042385/da09087d-c045-48c6-afe1-23afa8d9ba27)

<h3> Цикломатска комплексност </h3>
  <p> Цикломатската комплексност на овој граф е 11. Таа ја добив по бројот на региони во графот. </p>
  
<h3> Тест случаи за Every Branch </h3>
  ``` 
    @Test
    void exceptionTest(){
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
    }

    @Test
    void usernameTest(){
        Assertions.assertEquals(true, SILab2.function(new User(null, "boki_softversko", "boki2@smth.com"), Collections.emptyList()));
    }

    @Test
    void UsersTests() {
        User u1 = new User("boki", "boki_softversko", "boki@smth.com");
        List<User> users = new ArrayList<>();
        users.add(u1);

        Assertions.assertEquals(false, SILab2.function(new User("boki", "boki", "bokac@smth.com"), users));
    }

    @Test
    void spaceTest(){
        Assertions.assertEquals(false, SILab2.function(new User("boki", "boki finki", "bokac@smthcom"), Collections.emptyList()));
    }

    @Test
    void specialCharacterTest(){
        Assertions.assertEquals(false, SILab2.function(new User("boki", "bokisoftversko", "boki@smthcom"), Collections.emptyList()));
    } 
  ```
  
<h3> Тест случаи за Multiple Condition </h3>
  ``` 
    @Test
    void multipleConditionTest(){
        RuntimeException ex;
        //TXX
        ex=Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
        Assertions.assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //FTX
        ex=Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(new User("boki", null, "boki@smth.com"), null));
        Assertions.assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //FFT
        ex=Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(new User("boki", "boki_softversko", null), null));
        Assertions.assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //FFF
        Assertions.assertEquals(false, SILab2.function(new User("boki", "boki_softversko", "boki@smth.com"), Collections.emptyList()));
    }
  ```
    
<h3> Објаснување за unit тестовите </h3>
    <p> Во овој проект тестовите се пишувани така да бидат исполнети сите услови. Со assertThrows се фаќа исклучокот, кој потоа се праќа во променливата ex, која е 
      од тип RuntimeException. Истиот исклучок се проверува дали е соодветниот исклучок преку assertTrue. За проверување дали програмата враќа соодветен резултат се 
      користи assertEquals, каде како прв аргумент се прима очекуваниот резултат, а како втор арумент се прима вистинскиот резултат. Multiple Condition служи за проверување 
      на повеќе услови во еден if услов, доколку истиот има повеќе услови. </p>
    
