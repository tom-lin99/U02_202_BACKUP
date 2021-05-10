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
    if(num==null||num.length()!=3){//檢查長度
      return false;
    }else if(num.charAt(0)==num.charAt(1)//檢查是否有重複數字
            ||num.charAt(0)==num.charAt(2)
            ||num.charAt(1)==num.charAt(2)
    ){
      return false;
    }
    //其他為正確情況

    return true;
  }
// TO DO

private  int getAnum(String num,String luckyNum){
    int aNum =0;
    for (int i=0;i<luckyNum.length();i++){
      if(num.charAt(i)==luckyNum.charAt(i)){
        aNum++;
      }
    }
    return aNum;
}
private  int getBnum(String num,String luckyNum){
  int bNum =0;
  for (int i=0;i<luckyNum.length();i++){
    char x = luckyNum.charAt(i);
    if(num.charAt(i)==luckyNum.charAt(i)){//A NUM 情況跳過
    }else{
      // 自串有包含數字則+1
      int pos = num.indexOf(x);
      if(pos>=0)bNum++;
    }
  }
  return bNum;
}

  //按鈕事件
  @Override
  public void onClick(View v) {
    String userNum = edInputNum.getText().toString();
    // TO DO
    if(!isLegal(userNum)){
      edInputNum.setText("");//清空輸入框
      String msg = "輸入錯誤"+getText(R.string.title);
      tvRespond.setText(msg);

    }else{
      int numA = getAnum(userNum, luckyNum);
      int numB = getBnum(userNum, luckyNum);
      //
      if(numA==luckyNum.length()){
        //不清空輸入框
        String msg = String.format("INPUT 的數字 : %s 恭喜你答對了! 答案 : %s",userNum,luckyNum);
        tvRespond.setText(msg);
      }else {
        edInputNum.setText("");//清空輸入框
        String msg = String.format("INPUT 的數字 : %s = %dA%dB",userNum,numA,numB);
        tvRespond.setText(msg);
      }

    }
   }
  }

