package com.tqc.gdd02;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GDD02 extends Activity implements View.OnClickListener
{

  Button btnSubmit;
  EditText edInputNum;
  TextView tvRespond;
  //答案
  String luckyNum;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    btnSubmit = (Button) findViewById(R.id.submit);
    edInputNum = (EditText) findViewById(R.id.input_number);
    tvRespond = (TextView) findViewById(R.id.respond);

    btnSubmit.setOnClickListener(this);
    luckyNum = generateLuckyNum();
  }

  private String generateLuckyNum(){
    int num=0;
    String strNum = "";
    do{
      num = (int) (Math.random()*1000);
      strNum = String.format("%03d",num);
    }while(isLegal(strNum)==false);
    return strNum;
  }

  //判斷輸入數字符合規則
  private boolean isLegal(String num){
      // TO DO


  return true;
  }
// TO DO



  //按鈕事件
  @Override
  public void onClick(View v) {
    String userNum = edInputNum.getText().toString();
    // TO DO

    }
  }

