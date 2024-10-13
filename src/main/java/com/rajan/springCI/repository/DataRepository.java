package com.rajan.springCI.repository;

import com.rajan.springCI.model.DataObject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {

  public List<DataObject> dataObjects = new ArrayList<>();

  public void addData(DataObject dataObject) {
    dataObjects.add(dataObject);
  }

  public List<DataObject> getDataObjects() {
    return dataObjects;
  }

  public void deleteData(String data) {
    dataObjects = dataObjects.stream().filter(todo -> !todo.getData().equals(data))
        .collect(Collectors.toList());
  }
}
