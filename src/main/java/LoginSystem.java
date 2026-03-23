package com.example;

import java.util.HashMap;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;







public class LoginSystem extends Application{
    

GridPane root = new GridPane(10,10);  //replace this with GridPane



HashMap<String,String>users = new HashMap<>();
PauseTransition delay = new PauseTransition(Duration.seconds(3));




@Override


public void start(Stage stage){


root.setPadding(new Insets(20));
root.setAlignment(Pos.CENTER);



//notification message to use all over the system
Label notification = new Label();
notification.setStyle("-fx-text-fill:red;  -fx-font-style: italic;");






Menu(stage); //set as the first window


Scene scene = new Scene(root,1024,768);
stage.setTitle("Simple login system");
stage.setScene(scene);
stage.show();
    
}







//first screen
private void Menu(Stage stage){

root.getChildren().clear();



Button createaccount = new Button("Create account");
createaccount.setStyle("-fx-font-size: 17px; -fx-text-fill: white; -fx-background-color: blue; -fx-font-weight: bold;");
createaccount.setPrefWidth(200);
createaccount.setPrefHeight(30);


//HOVER EFFECTS

//Mouse entered
createaccount.setOnMouseEntered(event ->{

    createaccount.setStyle("-fx-font-weight:bold; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-color: blue;");

});

//Mouse exit

createaccount.setOnMouseExited(e ->{

createaccount.setStyle("-fx-font-size: 17px; -fx-text-fill: white; -fx-background-color: blue; -fx-font-weight: bold;");


});






createaccount.setOnAction(e -> CreateAccount(stage));


Button Login = new Button("Login");
Login.setPrefWidth(200);
Login.setPrefHeight(30);
Login.setStyle("-fx-font-size: 17px; -fx-text-fill: white; -fx-background-color: blue; -fx-font-weight: bold;");


//Mouse entered
Login.setOnMouseEntered(event ->{

    Login.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-color: blue;");

});



//Mouse exit

Login.setOnMouseExited(event ->{

Login.setStyle("-fx-font-size: 17px; -fx-text-fill: white; -fx-background-color: blue; -fx-font-weight: bold;");


});




Login.setOnAction(e -> Login(stage) );


root.add(createaccount,0,0);
root.add(Login,0,1);






}






//second screen

private void CreateAccount(Stage stage){

root.getChildren().clear();


Label notification = new Label();
Label header = new Label();

Label usernamelabel = new Label();

Label passwordlabel = new Label();



//header
header.setText("create a new account");
header.setStyle("-fx-font-size: 24px; -fx-font-weight:bold; -fx-text-fill: black;");

//username area
usernamelabel.setText("username/email");
usernamelabel.setStyle("-fx-font-size: 15px; -fx-text-fill: darkblue;");
TextField usernamefield = new TextField();
usernamefield.setPromptText("eg.hassan200503");
usernamefield.setPrefWidth(200);
usernamefield.setMaxWidth(200);



//password area
passwordlabel.setText("Set password");
passwordlabel.setStyle("-fx-font-size: 15px;  -fx-text-fill: darkblue;");

PasswordField setpasswordfield = new PasswordField();
setpasswordfield.setPromptText("set a srong password");
setpasswordfield.setPrefWidth(200);
setpasswordfield.setMaxWidth(200);


Label confirmlabel = new Label("confirm password");
confirmlabel.setStyle("-fx-font-size: 15px;  -fx-text-fill: darkblue;");

PasswordField confirmfield = new PasswordField();
confirmfield.setPromptText("confirm your password");
confirmfield.setPrefWidth(200);
confirmfield.setMaxWidth(200);

//setting heights of the fields

TextField[]fields = {usernamefield,setpasswordfield,confirmfield};

for(int y = 0; y <3; y++){

fields[y].setPrefHeight(33);
fields[y].setStyle("-fx-font-size: 14px;");



}





HBox layout = new HBox();
Label attachtologinlabel = new Label("Already have an account?");





//setting all labels at once



Label[]labels = {usernamelabel,passwordlabel,confirmlabel,attachtologinlabel};

for(int y = 0; y<4; y++){

labels[y].setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: darkblue;");

}





//create a hyperlink
Hyperlink login = new Hyperlink("Login here");
login.setStyle("-fx-text-fill:green; -fx-font-size: 14px; -fx-font-weight: bold;");

login.setOnAction(e -> Login(stage));

layout.getChildren().addAll(attachtologinlabel,login);





//create account button


Button create = new Button("Create account");
create.setPrefWidth(200);
create.setPrefHeight(20);
create.setStyle("-fx-font-size: 17px; -fx-text-fill: white;  -fx-background-color: blue; -fx-font-weight: bold; ");

//Mouse entered
create.setOnMouseEntered(event ->{

create.setStyle("-fx-font-size: 19px; -fx-font-weight:bold; -fx-text-fill: white; -fx-background-color: blue;");

});


//Mouse Exit
create.setOnMouseExited(event ->{

create.setStyle("-fx-font-size: 17px; -fx-text-fill: white;  -fx-background-color: blue; -fx-font-weight: bold; ");



});




create.setOnAction(e ->{


String password = setpasswordfield.getText();
String confirmpassword = confirmfield.getText();
String username = usernamefield.getText();


if(password.equals(confirmpassword) && !username.isEmpty()){

users.put(username,password);

notification.setText("SUCCESS:  " + usernamefield.getText() + " your account has been created successfully!");
notification.setStyle("-fx-font-size: 13px; -fx-text-fill: green; -fx-font-weight: bold;");

//set pause transition

delay.setOnFinished(event ->{
notification.setText("");
Login(stage);

});

delay.play();


}



else{

notification.setText("ERROR: Passwords do not match!");
notification.setStyle("-fx-font-size: 13px; -fx-font-weight:bold; -fx-text-fill: red; ");


delay.setOnFinished(event -> notification.setText(""));   //clear notification after 3 seconds
delay.play();


}


});



//GridPane root

root.add(notification,0,0);
root.add(header,0,1);
root.add(usernamelabel,0,2);
root.add(usernamefield,0,3);
root.add(passwordlabel,0,4);
root.add(setpasswordfield,0,5);
root.add(confirmlabel,0,6);
root.add(confirmfield,0,7);
root.add(create,0,8);
root.add(layout,0,9);



}






//LOGIN SCREEN



private void Login(Stage stage){


root.getChildren().clear();


Label notification = new Label();
Label header = new Label();

Label usernamelabel = new Label();

Label passwordlabel = new Label();




HBox layout = new HBox();
Label attachtosignuplabel = new Label("Don't have an account? ");
attachtosignuplabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: darkblue;");




Hyperlink signup = new Hyperlink("Register here");
signup.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: green;");

signup.setOnAction(e -> CreateAccount(stage));

layout.getChildren().addAll(attachtosignuplabel,signup);



header.setText("Login to your account!");
header.setStyle("-fx-font-size: 24px; -fx-font-weight:bold; -fx-text-fill: black;");


usernamelabel.setText("username/email");
usernamelabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: darkblue;");

TextField usernamefield = new TextField();
usernamefield.setPromptText("eg.hassan200503");
usernamefield.setPrefHeight(33);
usernamefield.setStyle("-fx-font-size: 14px;");

passwordlabel.setText("password");
passwordlabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: darkblue;");

PasswordField passwordfield = new PasswordField();
passwordfield.setPromptText("enter password ");
passwordfield.setPrefHeight(33);
passwordfield.setStyle("-fx-font-size: 14px;");




Button login = new Button("Login");
login.setPrefWidth(200);
login.setPrefHeight(30);
login.setStyle("-fx-font-size: 17px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: blue;");

//create a mouse event here


login.setOnMouseEntered(e ->{

login.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: blue;");


});


login.setOnMouseExited(e ->{

login.setStyle("-fx-font-size: 17px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: blue;");



});






login.setOnAction(e ->{

String username = usernamefield.getText();
String password = passwordfield.getText();



if(users.containsKey(username ) &&  users.get(username).equals(password)){

root.getChildren().clear();
header.setText("Welcome back, " + username);
header.setStyle("-fx-font-size: 24px; -fx-font-weight:bold; -fx-text-fill: blue;");



Button logout = new Button("Logout");
logout.setPrefWidth(200);
logout.setPrefHeight(30);
logout.setStyle("-fx-font-size: 17px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: blue;");

//Mouse action

logout.setOnMouseEntered(event ->{

logout.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: blue;");



});




logout.setOnMouseExited(event -> {

logout.setStyle("-fx-font-size: 17px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: blue;");



});








logout.setOnAction(ev -> Login(stage));

root.getChildren().addAll(header,logout);


}


else{

notification.setText("ERROR: Password or username incorrect!");
notification.setStyle("-fx-font-size: 13px; -fx-font-weight:bold; -fx-text-fill: red;");

delay.setOnFinished(event ->{

notification.setText("");


});


delay.play();





}




});




Hyperlink reset = new Hyperlink("Reset password");
reset.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: green;");

reset.setOnAction(event ->{


ResetPassword(stage);

});











root.add(notification,0,0);
root.add(header,0,1);
root.add(usernamelabel,0,2);
root.add(usernamefield,0,3);
root.add(passwordlabel,0,4);
root.add(passwordfield,0,5);
root.add(login,0,6);
root.add(layout,0,7);
root.add(reset,0,8);



}







//Forgot password screen


private void ResetPassword(Stage stage){

root.getChildren().clear();




Label notification = new Label();
Label header = new Label();




//header
header.setText("password reset");
header.setStyle("-fx-font-size: 24px; -fx-font-weight:bold; -fx-text-fill: black;");


//username area

Label usernamelabel = new Label();


usernamelabel.setText("username/email");
usernamelabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: darkblue;");

TextField usernamefield = new TextField();
usernamefield.setPromptText("eg.hassan200503");
usernamefield.setPrefHeight(33);
usernamefield.setStyle("-fx-font-size: 14px;");





//password area
Label passwordlabel = new Label();
passwordlabel.setText("Enter old password");
passwordlabel.setStyle("-fx-font-size: 15px;  -fx-text-fill: darkblue;");

PasswordField oldpasswordfield = new PasswordField();
oldpasswordfield.setPromptText("set a srong password");
oldpasswordfield.setPrefWidth(200);
oldpasswordfield.setMaxWidth(200);


Label newpasswordlabel = new Label("Enter new  password");
newpasswordlabel.setStyle("-fx-font-size: 15px;  -fx-text-fill: darkblue;");

PasswordField newpasswordfield = new PasswordField();
newpasswordfield.setPromptText("set a new password");
newpasswordfield.setPrefWidth(200);
newpasswordfield.setMaxWidth(200);





Label confirmlabel = new Label("confirm password");
confirmlabel.setStyle("-fx-font-size: 15px;  -fx-text-fill: darkblue;");

PasswordField confirmfield = new PasswordField();
confirmfield.setPromptText("confirm your password");
confirmfield.setPrefWidth(200);
confirmfield.setMaxWidth(200);



//setting heights of the fields

TextField[]fields = {oldpasswordfield,newpasswordfield,confirmfield,usernamefield};

for(int y = 0; y <4; y++){

fields[y].setPrefHeight(33);
fields[y].setStyle("-fx-font-size: 14px;");



}





//setting all labels at once



Label[]labels = {newpasswordlabel,passwordlabel,confirmlabel,usernamelabel};

for(int y = 0; y<3; y++){

labels[y].setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: darkblue;");

}





Button reset = new Button("Reset password");
reset.setPrefWidth(200);
reset.setPrefHeight(30);
reset.setStyle("-fx-font-size: 17px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: blue;");

//Mouse action

reset.setOnMouseEntered(event ->{

reset.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: blue;");



});




reset.setOnMouseExited(event -> {

reset.setStyle("-fx-font-size: 17px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: blue;");



});




reset.setOnAction(event ->{

String password = newpasswordfield.getText();
String confirmpassword =confirmfield.getText();
String oldpassword = oldpasswordfield.getText();
String username = usernamefield.getText();


String validator = users.get(username);


//prevent empty fields
String pass = newpasswordfield.getText().trim();
String confirm = confirmfield.getText().trim();
String user = usernamefield.getText().trim();
String old = oldpasswordfield.getText().trim();





if(validator != null && validator.equals(oldpassword)  &&  password.equals(confirmpassword) && !username.isEmpty() && !pass.isEmpty() && !confirm.isEmpty() && !user.isEmpty() && !old.isEmpty()){

users.put(username,password);
notification.setText("SUCCESS: password reset successfully!");
notification.setStyle("-fx-font-size: 13px; -fx-text-fill: green; -fx-font-weight: bold;");


delay.setOnFinished(ev ->{
notification.setText("");

});

delay.play();


} 


else if(pass.isEmpty() || user.isEmpty() || old.isEmpty() || confirm.isEmpty()){



notification.setText("ERROR: Password or username incorrect!");
notification.setStyle("-fx-font-size: 13px; -fx-font-weight:bold; -fx-text-fill: red;");

delay.setOnFinished(ev ->{

notification.setText("");

});

delay.play();



}



});








Hyperlink back = new Hyperlink("Go back to login");
back.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: green;");





back.setOnAction(event -> Login(stage));




//GridPane setup

root.add(notification,0,0);
root.add(header,0,1);
root.add(usernamelabel,0,2);
root.add(usernamefield,0,3);
root.add(passwordlabel,0,4);
root.add(oldpasswordfield,0,5);
root.add(newpasswordlabel,0,6);
root.add(newpasswordfield,0,7);
root.add(confirmlabel,0,8);
root.add(confirmfield,0,9);
root.add(reset,0,10);
root.add(back,0,11);











}




















public static void main(String[]args){



launch(args);




}




}
