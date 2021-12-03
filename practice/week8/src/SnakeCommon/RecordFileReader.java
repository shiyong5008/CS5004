package SnakeCommon;

import java.io.File;
import java.util.Scanner;

public class RecordFileReader implements GameInput {
  public RecordFileReader(String recordFilePath) {
    try {
      recordReader = new Scanner(new File(recordFilePath));
    } catch (Exception e) {
      System.out.println("record folder not found");
    }
  }

  @Override
  public String getInput() {
    if (recordReader.hasNextLine()) {
      input = recordReader.nextLine();
    }

    return input;
  }

  @Override
  public boolean isKeyBoard() {
    return false;
  }

  private Scanner recordReader;
  private String input;
}
