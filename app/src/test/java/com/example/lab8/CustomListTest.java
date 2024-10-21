package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    public void hasCityTest() {
        CustomList list = MockCityList();  // 创建一个空的城市列表
        City city = new City("Edmonton", "AB");
        list.addCity(city);  // 将城市添加到列表中
        assertTrue(list.hasCity(city));  // 检查列表中是否包含该城市
    }

    @Test
    public void deleteCityTest() {
        CustomList list = MockCityList();  // 初始化空的城市列表
        City city = new City("Edmonton", "AB");
        list.addCity(city);  // 添加城市到列表中
        assertTrue(list.hasCity(city));  // 确保城市在列表中
        list.deleteCity(city);  // 删除城市
        assertFalse(list.hasCity(city));  // 确保城市已从列表中删除
    }

    @Test
    public void countCitiesTest() {
        CustomList list = MockCityList();  // 初始化空的城市列表
        assertEquals(0, list.countCities());  // 检查列表为空时数量为 0
        list.addCity(new City("Calgary", "AB"));  // 添加城市
        assertEquals(1, list.countCities());  // 检查城市数量是否增加
        list.addCity(new City("Toronto", "ON"));  // 再添加一个城市
        assertEquals(2, list.countCities());  // 检查城市数量是否正确
    }



}
