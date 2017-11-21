package com.example.laowa.eatfooddemo.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.R;

import static com.example.laowa.eatfooddemo.R.id.dialog_boy;

/*
 *
 * Created by Administrator on 2017/10/28.
 */

public class PersonMessageActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout changeHeadPhoto;
    private RelativeLayout changeUserName;
    private RelativeLayout changeUserEmail;
    private RelativeLayout changeUserSchool;
    private RelativeLayout changUserNumber;
    private RelativeLayout changeUserPersonalizedSignature;
    private RelativeLayout changeUserSix;
    private RelativeLayout changeUserBirthday;
    private RelativeLayout changeUserLocation;
    private RelativeLayout changeUserCollege;
    private RelativeLayout changeUserMajor;
    private RelativeLayout changeUserEnrollmentYear;
    private RelativeLayout changeUserHobby;

    private ImageView personHeadImage;
    private TextView personName;
    private TextView personEmail;
    private TextView personSchool;
    private TextView personNumber;
    private TextView personPersonalizedSignature;
    private TextView personSix;
    private TextView personBirthday;
    private TextView personLocation;
    private TextView personCollege;
    private TextView personMajor;
    private TextView personEnrollmentYear;
    private TextView personHobby;
    private Button backUp;
    SharedPreferences preferences;
    private AlertDialog.Builder alertDialog = null;
    private AlertDialog.Builder builder = null;


    private int year, monthOfYear, dayOfMonth;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_message);
        preferences = getSharedPreferences("data",MODE_PRIVATE);
        initView();

    }

    private void initView() {
        changeHeadPhoto = (RelativeLayout) findViewById(R.id.change_head_photo);
        changeUserEmail = (RelativeLayout) findViewById(R.id.change_user_email);
        changeUserName = (RelativeLayout) findViewById(R.id.change_user_name);
        changeUserSchool = (RelativeLayout) findViewById(R.id.change_user_school);
        changUserNumber = (RelativeLayout) findViewById(R.id.change_user_number);
        changeUserPersonalizedSignature = (RelativeLayout) findViewById(R.id.change_user_personalized_signature);
        changeUserSix = (RelativeLayout) findViewById(R.id.change_user_six);
        changeUserBirthday = (RelativeLayout) findViewById(R.id.change_user_birthday);
        changeUserLocation = (RelativeLayout) findViewById(R.id.change_user_location);
        changeUserCollege = (RelativeLayout) findViewById(R.id.change_user_college);
        changeUserMajor = (RelativeLayout) findViewById(R.id.change_user_major);
        changeUserEnrollmentYear = (RelativeLayout) findViewById(R.id.change_user_enrollment_year);
        changeUserHobby = (RelativeLayout) findViewById(R.id.change_user_hobby);

        personSix = (TextView) findViewById(R.id.person_six);
        personSix.setText("" + preferences.getString("sex", ""));
        personBirthday = (TextView) findViewById(R.id.person_birthday);
        personBirthday.setText("" + preferences.getString("birthday", ""));
        personLocation = (TextView) findViewById(R.id.person_location);
        personLocation.setText("" + preferences.getString("local", ""));
        personCollege = (TextView) findViewById(R.id.person_college);
        personCollege.setText("" + preferences.getString("college", ""));
        personMajor = (TextView) findViewById(R.id.person_major);
        personMajor.setText("" + preferences.getString("major", ""));
        personEnrollmentYear = (TextView) findViewById(R.id.person_enrollment_year);
        personEnrollmentYear.setText("" + preferences.getString("enrollmentYear", ""));
        personHobby = (TextView) findViewById(R.id.person_hobby);
        personHobby.setText("" + preferences.getString("hobby", ""));
        personHeadImage = (ImageView) findViewById(R.id.person_head_photo);
        personNumber = (TextView) findViewById(R.id.person_number);
        personNumber.setText("" + preferences.getString("schoolID", ""));
        personName = (TextView) findViewById(R.id.person_name);
        personName.setText("" + preferences.getString("name", ""));
        personSchool = (TextView) findViewById(R.id.person_school);
        personSchool.setText("" + preferences.getString("school", ""));
        personEmail = (TextView) findViewById(R.id.person_email);
        personEmail.setText("" + preferences.getString("email", ""));
        personPersonalizedSignature = (TextView) findViewById(R.id.person_personalized_signature);
        personPersonalizedSignature.setText("" + preferences.getString("personalizedSignature", "schoolID"));
        backUp = (Button) findViewById(R.id.back_up);

        backUp.setOnClickListener(this);
        changeHeadPhoto.setOnClickListener(this);
        changeUserEmail.setOnClickListener(this);
        changeUserName.setOnClickListener(this);
        changeUserSchool.setOnClickListener(this);
        changUserNumber.setOnClickListener(this);
        changeUserPersonalizedSignature.setOnClickListener(this);
        changeUserEnrollmentYear.setOnClickListener(this);
        changeUserHobby.setOnClickListener(this);
        changeUserSix.setOnClickListener(this);
        changeUserBirthday.setOnClickListener(this);
        changeUserLocation.setOnClickListener(this);
        changeUserCollege.setOnClickListener(this);
        changeUserMajor.setOnClickListener(this);
        personHeadImage.setOnClickListener(this);
        personNumber.setOnClickListener(this);
        personName.setOnClickListener(this);
        personSchool.setOnClickListener(this);
        personEmail.setOnClickListener(this);
        personPersonalizedSignature.setOnClickListener(this);
        personSix.setOnClickListener(this);
        personBirthday.setOnClickListener(this);
        personLocation.setOnClickListener(this);
        personCollege.setOnClickListener(this);
        personMajor.setOnClickListener(this);
        personEnrollmentYear.setOnClickListener(this);
        personHobby.setOnClickListener(this);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        monthOfYear = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        switch (v.getId()){
            case R.id.change_head_photo:
                Toast.makeText(getApplicationContext(),"photo",Toast.LENGTH_SHORT).show();
                break;
            case R.id.change_user_email:
                Toast.makeText(getApplicationContext(),"email",Toast.LENGTH_SHORT).show();
                break;
            case R.id.person_name:
            case R.id.change_user_name:
                final EditText changeNameEditText = new EditText(getApplicationContext());
                changeNameEditText.setTextColor(getResources().getColor(R.color.bg_black));
                changeNameEditText.setMaxEms(6);
                alertDialog = null;
                builder = new AlertDialog.Builder(this);
                builder.setTitle("名字").setView(changeNameEditText);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!changeNameEditText.getText().toString().equals("") &&
                                changeNameEditText.getText().toString().length() <= 6){
                            personName.setText(changeNameEditText.getText().toString());
                        }else if (changeNameEditText.getText().toString().equals("")) {
                            Toast.makeText(PersonMessageActivity.this, "名字不能为空", Toast.LENGTH_SHORT).show();
                        }else if (changeNameEditText.getText().toString().length() > 6){
                            Toast.makeText(PersonMessageActivity.this, "名字不能超过6个字符", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name",changeNameEditText.getText().toString());
                editor.apply();
                break;
            case R.id.person_six:
            case R.id.change_user_six:
                View dialogSixView = View.inflate(PersonMessageActivity.this,R.layout.dialog_six_choose,null);
                final TextView dialogBoy = (TextView) dialogSixView.findViewById(R.id.dialog_boy);
                final TextView dialogGirl = (TextView) dialogSixView.findViewById(R.id.dialog_girl);
                final RelativeLayout dialogBoyRelative = (RelativeLayout) dialogSixView.findViewById(R.id.dialog_boy_relative);
                final RelativeLayout dialogGrilRelative = (RelativeLayout) dialogSixView.findViewById(R.id.dialog_girl_relative);
                alertDialog = null;
                builder = new AlertDialog.Builder(this);
                alertDialog = builder.setView(dialogSixView);
                dialogBoyRelative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(PersonMessageActivity.this, "you are a " + dialogBoy.getText().toString(), Toast.LENGTH_SHORT).show();
                        personSix.setText(dialogBoy.getText().toString());
                       builder.create().dismiss();
                    }
                });
                dialogGrilRelative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(PersonMessageActivity.this, "you are a " + dialogGirl.getText().toString(), Toast.LENGTH_SHORT).show();
                        personSix.setText(dialogGirl.getText().toString());
                        builder.create().dismiss();
                    }
                });
                Log.d("showshowshowshowshwo","=======");
                builder.create().show();
                break;
            case R.id.person_birthday:
            case R.id.change_user_birthday:
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        PersonMessageActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        personBirthday.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth );
                    }
                },year,monthOfYear,dayOfMonth);
                datePickerDialog.show();
                break;
            case R.id.person_location:
            case R.id.change_user_location:
                final EditText changeLocationEditText = new EditText(getApplicationContext());
                changeLocationEditText.setTextColor(getResources().getColor(R.color.bg_black));
                changeLocationEditText.setMaxEms(6);
                alertDialog = null;
                builder = new AlertDialog.Builder(this);
                builder.setTitle("家乡").setView(changeLocationEditText);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!changeLocationEditText.getText().toString().equals("") &&
                                changeLocationEditText.getText().toString().length() <= 6){
                            personLocation.setText(changeLocationEditText.getText().toString());
                        }else if (changeLocationEditText.getText().toString().equals("")) {
                            Toast.makeText(PersonMessageActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                        }else if (changeLocationEditText.getText().toString().length() > 6){
                            Toast.makeText(PersonMessageActivity.this, "不能超过12个字符", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                break;
            case R.id.person_college:
            case R.id.change_user_college:
                final EditText changeCollegeEditText = new EditText(getApplicationContext());
                changeCollegeEditText.setTextColor(getResources().getColor(R.color.bg_black));
                changeCollegeEditText.setMaxEms(12);
                changeCollegeEditText.setInputType(InputType.TYPE_CLASS_PHONE);
                alertDialog = null;
                builder = new AlertDialog.Builder(this);
                builder.setTitle("学院").setView(changeCollegeEditText);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!changeCollegeEditText.getText().toString().equals("") &&
                                changeCollegeEditText.getText().toString().length() <= 12){
                            personCollege.setText(changeCollegeEditText.getText().toString());
                        }else if (changeCollegeEditText.getText().toString().equals("")) {
                            Toast.makeText(PersonMessageActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                        }else if (changeCollegeEditText.getText().toString().length() > 12){
                            Toast.makeText(PersonMessageActivity.this, "不能超过30个字符", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                break;
            case R.id.person_major:
            case R.id.change_user_major:
                final EditText changeMajorEditText = new EditText(getApplicationContext());
                changeMajorEditText.setTextColor(getResources().getColor(R.color.bg_black));
                changeMajorEditText.setMaxEms(12);
                changeMajorEditText.setInputType(InputType.TYPE_CLASS_PHONE);
                alertDialog = null;
                builder = new AlertDialog.Builder(this);
                builder.setTitle("专业").setView(changeMajorEditText);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!changeMajorEditText.getText().toString().equals("") &&
                                changeMajorEditText.getText().toString().length() <= 12){
                            personMajor.setText(changeMajorEditText.getText().toString());
                        }else if (changeMajorEditText.getText().toString().equals("")) {
                            Toast.makeText(PersonMessageActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                        }else if (changeMajorEditText.getText().toString().length() > 12){
                            Toast.makeText(PersonMessageActivity.this, "不能超过30个字符", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                break;
            case R.id.person_enrollment_year:
            case R.id.change_user_enrollment_year:
                final EditText changeEnrollmentYearEditText = new EditText(getApplicationContext());
                changeEnrollmentYearEditText.setTextColor(getResources().getColor(R.color.bg_black));
                changeEnrollmentYearEditText.setMaxEms(5);
                changeEnrollmentYearEditText.setInputType(InputType.TYPE_CLASS_PHONE);
                alertDialog = null;
                builder = new AlertDialog.Builder(this);
                builder.setTitle("输入年份").setView(changeEnrollmentYearEditText);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!changeEnrollmentYearEditText.getText().toString().equals("") &&
                                changeEnrollmentYearEditText.getText().toString().length() <= 5){
                            personEnrollmentYear.setText(changeEnrollmentYearEditText.getText().toString());
                        }else if (changeEnrollmentYearEditText.getText().toString().equals("")) {
                            Toast.makeText(PersonMessageActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                        }else if (changeEnrollmentYearEditText.getText().toString().length() > 5){
                            Toast.makeText(PersonMessageActivity.this, "不能超过30个字符", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                break;
            case R.id.person_hobby:
            case R.id.change_user_hobby:
                final EditText changeHobbyEditText = new EditText(getApplicationContext());
                changeHobbyEditText.setTextColor(getResources().getColor(R.color.bg_black));
                changeHobbyEditText.setMaxEms(50);
                alertDialog = null;
                builder = new AlertDialog.Builder(this);
                builder.setTitle("爱好").setView(changeHobbyEditText);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!changeHobbyEditText.getText().toString().equals("") &&
                                changeHobbyEditText.getText().toString().length() <= 30){
                            personHobby.setText(changeHobbyEditText.getText().toString());
                        }else if (changeHobbyEditText.getText().toString().equals("")) {
                            Toast.makeText(PersonMessageActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                        }else if (changeHobbyEditText.getText().toString().length() > 30){
                            Toast.makeText(PersonMessageActivity.this, "不能超过30个字符", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                break;
            case R.id.person_number:
            case R.id.change_user_number:
                final EditText changeNumberEditText = new EditText(getApplicationContext());
                changeNumberEditText.setTextColor(getResources().getColor(R.color.bg_black));
                changeNumberEditText.setMaxEms(50);

                alertDialog = null;
                builder = new AlertDialog.Builder(this);
                builder.setTitle("学号").setView(changeNumberEditText);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!changeNumberEditText.getText().toString().equals("") &&
                                changeNumberEditText.getText().toString().length() <= 15){
                            personNumber.setText(changeNumberEditText.getText().toString());
                        }else if (changeNumberEditText.getText().toString().equals("")) {
                            Toast.makeText(PersonMessageActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                        }else if (changeNumberEditText.getText().toString().length() > 15){
                            Toast.makeText(PersonMessageActivity.this, "不能超过50个字符", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                break;
            case R.id.person_personalized_signature:
            case R.id.change_user_personalized_signature:
                final EditText changePersonalizedEditText = new EditText(getApplicationContext());
                changePersonalizedEditText.setTextColor(getResources().getColor(R.color.bg_black));
                changePersonalizedEditText.setMaxEms(50);
                alertDialog = null;
                builder = new AlertDialog.Builder(this);
                builder.setTitle("个性签名").setView(changePersonalizedEditText);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!changePersonalizedEditText.getText().toString().equals("") &&
                                changePersonalizedEditText.getText().toString().length() <= 50){
                            personPersonalizedSignature.setText(changePersonalizedEditText.getText().toString());
                        }else if (changePersonalizedEditText.getText().toString().equals("")) {
                            Toast.makeText(PersonMessageActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                        }else if (changePersonalizedEditText.getText().toString().length() > 50){
                            Toast.makeText(PersonMessageActivity.this, "不能超过12个字符", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                break;
            case R.id.person_school:
            case R.id.change_user_school:
                final EditText changeSchoolEditText = new EditText(getApplicationContext());
                changeSchoolEditText.setTextColor(getResources().getColor(R.color.bg_black));
                changeSchoolEditText.setMaxEms(12);
                alertDialog = null;
                builder = new AlertDialog.Builder(this);
                builder.setTitle("学校").setView(changeSchoolEditText);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!changeSchoolEditText.getText().toString().equals("") &&
                                changeSchoolEditText.getText().toString().length() <= 12){
                            personSchool.setText(changeSchoolEditText.getText().toString());
                        }else if (changeSchoolEditText.getText().toString().equals("")) {
                            Toast.makeText(PersonMessageActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                        }else if (changeSchoolEditText.getText().toString().length() > 12){
                            Toast.makeText(PersonMessageActivity.this, "不能超过12个字符", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                break;
            case R.id.person_email:
                Toast.makeText(getApplicationContext(),"person_email",Toast.LENGTH_SHORT).show();
                break;
            case R.id.person_head_photo:
                Toast.makeText(getApplicationContext(),"person_head_photo",Toast.LENGTH_SHORT).show();
                break;
            case R.id.back_up:
                Intent personalMessageBackPersonalShow = new Intent(PersonMessageActivity.this,PersonShowActivity.class);
                startActivity(personalMessageBackPersonalShow);
                finish();

            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
