package com.rajan.springCI.repository;

import com.rajan.springCI.model.DataObject;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataRepositoryTest {

  public DataRepository dataRepository;

  @BeforeEach
  public void setup() {
    dataRepository = new DataRepository();
    DataObject dataObject = new DataObject();
    dataObject.setData("hello world");
    dataRepository.addData(dataObject);
  }

  @Test
  void addData() {
    //should be able to add data

    //arrange
    DataObject dataObject = new DataObject();
    dataObject.setData("this is so cool");

    //act
    dataRepository.addData(dataObject);

    //assert
    Assertions.assertAll("test",
        () -> Assertions.assertEquals(dataRepository.getDataObjects().size(), 2,
            "size should be 1"));
  }

  @Test
  void getDataObjects() {
    //arrange

    //act
    List<DataObject> dataObjectList = dataRepository.getDataObjects();

    //asserrt
    Assertions.assertEquals(1, dataObjectList.size());
  }

  @Test
  void deleteData() {

    //arrange
    DataObject dataObject = new DataObject();
    dataObject.setData("hello world");

    //act
    dataRepository.deleteData(dataObject.getData());
    int size = dataRepository.getDataObjects().size();
    //assert
    Assertions.assertEquals(size, 0);
  }
}