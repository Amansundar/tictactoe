package com.aman.game.tictactoe;

import android.content.res.Configuration;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainScreen extends AppCompatActivity  {

    private String[][] board ;
    private int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board = new String[3][3];
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

//        // Checks the orientation of the screen
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
//            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
//        }
    }

    public void clearGame(final int machineWon){

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int id = getResources().getIdentifier(("id_"+i)+j, "id", getPackageName());
                TextView views = ((TextView)findViewById(id));
                views.setEnabled(false);
            }
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                count=0;
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        board[i][j] = "";
                        int id = getResources().getIdentifier(("id_"+i)+j, "id", getPackageName());
                        TextView views = ((TextView)findViewById(id));
                        views.setText("");
                        views.setEnabled(true);
                    }
                }
                if(machineWon>0){
                    onClick(null);
                }
            }
        },5000);

    }


    public void onClick(View view) {

        if(view!=null) {
            ((TextView) view).setText("0");
            ++count;
            switch (view.getId()) {
                case R.id.id_00:
                    board[0][0] = "0";
                    break;
                case R.id.id_01:
                    board[0][1] = "0";
                    break;
                case R.id.id_02:
                    board[0][2] = "0";
                    break;
                case R.id.id_10:
                    board[1][0] = "0";
                    break;
                case R.id.id_11:
                    board[1][1] = "0";
                    break;
                case R.id.id_12:
                    board[1][2] = "0";
                    break;
                case R.id.id_20:
                    board[2][0] = "0";
                    break;
                case R.id.id_21:
                    board[2][1] = "0";
                    break;
                case R.id.id_22:
                    board[2][2] = "0";
                    break;
            }
            view.setEnabled(false);
        }
        String choose_id=null;
        int machineWon=0;
        if (count > 1 && count < 9) {



            // check machine is in winning stage

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j]=="X") {

                        // iscentre corner
                        if ((i + j) % 2 != 0) {
                            // do vertical check
                            int choose_i = 0, temp_cnt = 0;
                            for (int k = 0; k < board.length; k++) {
                                if (board[k][j]=="X") {
                                    ++temp_cnt;
                                } else
                                    choose_i = k;
                            }
                            if(temp_cnt>1 && (board[choose_i][j]==null || board[choose_i][j]=="") ) {
                                choose_id = ("id_" + choose_i) + j;
                                break;
                            }
                            // do horizontal check
                            choose_i = 0;
                            temp_cnt = 0;
                            for (int k = 0; k < board.length; k++) {
                                if (board[i][k]=="X") {
                                    ++temp_cnt;
                                } else
                                    choose_i = k;
                            } if(temp_cnt>1 && (board[i][choose_i]==null || board[i][choose_i]=="") ) {
                                choose_id = ("id_" + i) +choose_i;
                                break;
                            }

                        } else if (i == 1 && j == 1) {

                            // do vertical check
                            int choose_i = 0, temp_cnt = 0;
                            for (int k = 0; k < board.length; k++) {
                                if (board[k][j]=="X") {
                                    ++temp_cnt;
                                } else
                                    choose_i = k;
                            }
                            if(temp_cnt>1 && (board[choose_i][j]==null || board[choose_i][j]=="") ){
                                choose_id = ("id_" + choose_i) + j;
                                break;
                            }

                            // do horizontal check
                            choose_i = 0;
                            temp_cnt = 0;
                            for (int k = 0; k < board.length; k++) {
                                if (board[i][k]=="X") {
                                    ++temp_cnt;
                                } else
                                    choose_i = k;
                            } if(temp_cnt>1 && (board[i][choose_i]==null || board[i][choose_i]=="")) {
                                choose_id = ("id_" + i) +choose_i;
                                break;
                            }

                            // left cross check
                            choose_i = 0;
                            temp_cnt = 0;
                            for (int k = 0; k < board.length; k++) {
                                if (board[k][k]=="X") {
                                    ++temp_cnt;
                                } else
                                    choose_i = k;
                            }if(temp_cnt>1 && (board[choose_i][choose_i]==null || board[choose_i][choose_i]=="")) {
                                choose_id = ("id_" + choose_i) +choose_i;
                                break;
                            }
                            // right cross check
                            choose_i = 0;
                            temp_cnt = 0;
                            for (int k = 0; k < board.length; k++) {
                                if (board[k][2 - k]=="X") {
                                    ++temp_cnt;
                                } else
                                    choose_i = k;
                            }if(temp_cnt>1 && (board[choose_i][2-choose_i]==null || board[choose_i][2-choose_i]=="")) {
                                choose_id = ("id_" + choose_i) +(2-choose_i);
                                break;
                            }

                        } else {

                            // do vertical check
                            int choose_i = 0, temp_cnt = 0;
                            for (int k = 0; k < board.length; k++) {
                                if (board[k][j]=="X") {
                                    ++temp_cnt;
                                } else
                                    choose_i = k;
                            }
                            if(temp_cnt>1 && (board[choose_i][j]==null || board[choose_i][j]=="")) {
                                choose_id = ("id_" + choose_i) + j;
                                break;
                            }

                            // do horizontal check
                            choose_i = 0;
                            temp_cnt = 0;
                            for (int k = 0; k < board.length; k++) {
                                if (board[i][k]=="X") {
                                    ++temp_cnt;
                                } else
                                    choose_i = k;
                            } if(temp_cnt>1&& (board[i][choose_i]==null || board[i][choose_i]=="")) {
                                choose_id = ("id_" + i) +choose_i;
                                break;
                            }

                            // cross check

                            if (i != j) {
                                choose_i = 0;
                                temp_cnt = 0;
                                for (int k = 0; k < board.length; k++) {
                                    if (board[k][2 - k]=="X") {
                                        ++temp_cnt;
                                    } else
                                        choose_i = k;
                                }if(temp_cnt>1 && (board[choose_i][2-choose_i]==null || board[choose_i][2-choose_i]=="")) {
                                    choose_id = ("id_" + choose_i) +(2-choose_i);
                                    break;
                                }

                            } else {
                                choose_i = 0;
                                temp_cnt = 0;
                                for (int k = 0; k < board.length; k++) {
                                    if (board[k][k]=="X") {
                                        ++temp_cnt;
                                    } else
                                        choose_i = k;
                                }if(temp_cnt>1 && (board[choose_i][choose_i]==null || board[choose_i][choose_i]=="")) {
                                    choose_id = ("id_" + choose_i) +choose_i;
                                    break;
                                }
                            }

                        }

                    }

                }

                if(choose_id!=null){
                    machineWon=1;
                    break;
                }
            }

            // check opp is in winning stage
            if(choose_id==null) {
                int temp_cnt = 0;
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (board[i][j]=="0") {

                            // iscentre corner
                            if ((i + j) % 2 != 0) {
                                // do vertical check
                                int choose_i = 0;temp_cnt = 0;
                                for (int k = 0; k < board.length; k++) {
                                    if (board[k][j]=="0") {
                                        ++temp_cnt;
                                    } else
                                        choose_i = k;
                                }
                                if(temp_cnt>1 && (board[choose_i][j]==null || board[choose_i][j]=="") ) {
                                    choose_id = ("id_" + choose_i) + j;
                                    break;
                                }
                                // do horizontal check
                                choose_i = 0;
                                temp_cnt = 0;
                                for (int k = 0; k < board.length; k++) {
                                    if (board[i][k]=="0") {
                                        ++temp_cnt;
                                    } else
                                        choose_i = k;
                                } if(temp_cnt>1 && (board[i][choose_i]==null || board[i][choose_i]=="") ) {
                                    choose_id = ("id_" + i) +choose_i;
                                    break;
                                }

                            } else if (i == 1 && j == 1) {

                                // do vertical check
                                int choose_i = 0;temp_cnt = 0;
                                for (int k = 0; k < board.length; k++) {
                                    if (board[k][j]=="0") {
                                        ++temp_cnt;
                                    } else
                                        choose_i = k;
                                }
                                if(temp_cnt>1 && (board[choose_i][j]==null || board[choose_i][j]=="") ){
                                    choose_id = ("id_" + choose_i) + j;
                                    break;
                                }

                                // do horizontal check
                                choose_i = 0;
                                temp_cnt = 0;
                                for (int k = 0; k < board.length; k++) {
                                    if (board[i][k]=="0") {
                                        ++temp_cnt;
                                    } else
                                        choose_i = k;
                                } if(temp_cnt>1 && (board[i][choose_i]==null || board[i][choose_i]=="")) {
                                    choose_id = ("id_" + i) +choose_i;
                                    break;
                                }

                                // left cross check
                                choose_i = 0;
                                temp_cnt = 0;
                                for (int k = 0; k < board.length; k++) {
                                    if (board[k][k]=="0") {
                                        ++temp_cnt;
                                    } else
                                        choose_i = k;
                                }if(temp_cnt>1 && (board[choose_i][choose_i]==null || board[choose_i][choose_i]=="")) {
                                    choose_id = ("id_" + choose_i) +choose_i;
                                    break;
                                }
                                // right cross check
                                choose_i = 0;
                                temp_cnt = 0;
                                for (int k = 0; k < board.length; k++) {
                                    if (board[k][2 - k]=="0") {
                                        ++temp_cnt;
                                    } else
                                        choose_i = k;
                                }if(temp_cnt>1 && (board[choose_i][2-choose_i]==null || board[choose_i][2-choose_i]=="")) {
                                    choose_id = ("id_" + choose_i) +(2-choose_i);
                                    break;
                                }

                            } else {

                                // do vertical check
                                int choose_i = 0;temp_cnt = 0;
                                for (int k = 0; k < board.length; k++) {
                                    if (board[k][j]=="0") {
                                        ++temp_cnt;
                                    } else
                                        choose_i = k;
                                }
                                if(temp_cnt>1 && (board[choose_i][j]==null || board[choose_i][j]=="")) {
                                    choose_id = ("id_" + choose_i) + j;
                                    break;
                                }

                                // do horizontal check
                                choose_i = 0;
                                temp_cnt = 0;
                                for (int k = 0; k < board.length; k++) {
                                    if (board[i][k]=="0") {
                                        ++temp_cnt;
                                    } else
                                        choose_i = k;
                                } if(temp_cnt>1&& (board[i][choose_i]==null || board[i][choose_i]=="")) {
                                    choose_id = ("id_" + i) +choose_i;
                                    break;
                                }

                                // cross check

                                if (i != j) {
                                    choose_i = 0;
                                    temp_cnt = 0;
                                    for (int k = 0; k < board.length; k++) {
                                        if (board[k][2 - k]=="0") {
                                            ++temp_cnt;
                                        } else
                                            choose_i = k;
                                    }if(temp_cnt>1 && (board[choose_i][2-choose_i]==null || board[choose_i][2-choose_i]=="")) {
                                        choose_id = ("id_" + choose_i) +(2-choose_i);
                                        break;
                                    }

                                } else {
                                    choose_i = 0;
                                    temp_cnt = 0;
                                    for (int k = 0; k < board.length; k++) {
                                        if (board[k][k]=="0") {
                                            ++temp_cnt;
                                        } else
                                            choose_i = k;
                                    }if(temp_cnt>1 && (board[choose_i][choose_i]==null || board[choose_i][choose_i]=="")) {
                                        choose_id = ("id_" + choose_i) +choose_i;
                                        break;
                                    }
                                }

                            }

                        }

                    }

                    if(choose_id!=null){
                        if(temp_cnt==3)
                            machineWon=-1;
                        break;
                    }
                }
            }


            // choose a point

            // priority 1
            // choose middle point
            if(choose_id==null) {
                int temp_oCnt = 0, temp_Xcnt = 0;
                if (board[1][1] == "" || board[1][1] == null) {
                    choose_id = "id_11";
                } else {
                    for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board[i].length; j++) {
                            if ((i % 2 == 0 && j % 2 == 0)) {
                                if( board[i][j] == "X")
                                    ++temp_Xcnt;
                                else if(board[i][j] == "0")
                                    ++temp_oCnt;
                            }
                        }
                    }
                    if (temp_Xcnt == 1) {
                        for (int i = 0; i < board.length; i++) {
                            for (int j = 0; j < board[i].length; j++) {
                                if ((i % 2 == 0 && j % 2 == 0) && board[i][j] == "X") {
                                    //++temp_cnt;
                                    if (i == 0) {
                                        if(j==0) {
                                            if (board[2][2] == null || board[2][2] == "") {
                                                choose_id = ("id_" + 2) + (2);
                                                break;
                                            }
                                            if (board[0][1] == null || board[0][1] == ""){
                                                if (board[0][2] == null || board[0][2] == "") {
                                                    choose_id = ("id_" + i) + (2);
                                                    break;
                                                }
                                            }
                                            if (board[1][0] == null || board[1][0] == "")
                                                if (board[2][j] == null|| board[2][j] == "") {
                                                    choose_id = ("id_" + 2) + (0);
                                                    break;
                                                }
                                        }
                                        else{
                                            if (board[2][0] == null || board[2][0] == "") {
                                                choose_id = ("id_" + 2) + (0);
                                                break;
                                            }
                                            if (board[0][1] == null || board[0][1] == ""){
                                                if (board[0][0] == null || board[1][0] == "") {
                                                    choose_id = ("id_" + i) + (0);
                                                    break;
                                                }
                                            }
                                            if (board[1][j] == null || board[1][j] == "")
                                                if (board[2][j] == null|| board[2][j] == "") {
                                                    choose_id = ("id_" + 2) + (j);
                                                    break;
                                                }
                                        }
                                        if (board[0][1] == null || board[0][1] == "")
                                            if (board[1][j] == null|| board[1][j] == "") {
                                                choose_id = ("id_" + i) + (2 - j);
                                                break;
                                            }
                                    }
                                    if (i == 2) {
                                        if(j==0) {
                                            if (board[0][2] == null || board[0][2] == "") {
                                                choose_id = ("id_" + 0) + (2);
                                                break;
                                            }
                                            if (board[1][j] == null || board[1][j] == ""){
                                                if (board[0][j] == null || board[0][j] == "") {
                                                    choose_id = ("id_" + 0) + (j);
                                                    break;
                                                }
                                            }
                                            if (board[i][1] == null || board[i][1] == "")
                                                if (board[i][2] == null|| board[i][2] == "") {
                                                    choose_id = ("id_" + 2) + (2);
                                                    break;
                                                }
                                        }
                                        else{
                                            if (board[0][0] == null || board[0][0] == "") {
                                                choose_id = ("id_" + 0) + (0);
                                                break;
                                            }
                                            if (board[i][1] == null || board[i][1] == ""){
                                                if (board[i][0] == null || board[i][0] == "") {
                                                    choose_id = ("id_" + i) + (0);
                                                    break;
                                                }
                                            }
                                            if (board[1][j] == null || board[1][j] == "")
                                                if (board[0][j] == null|| board[0][j] == "") {
                                                    choose_id = ("id_" + 0) + (j);
                                                    break;
                                                }
                                        }
                                    }
                                }
                            }
                            if (choose_id != null)
                                break;
                            else{
                                for ( i = 0; i < board.length; i++) {
                                    for (int j = 0; j < board[i].length; j++) {
                                        if ((i % 2 == 0 && j % 2 == 0)) {
                                            if( board[i][j] == "" || board[i][j] == null) {
                                                choose_id = ("id_" + i) + (j);
                                                break;
                                            }
                                        }
                                    }
                                    if (choose_id != null)
                                        break;
                                }
                            }
                        }
                    }
                    if (temp_Xcnt == 2) {
                        for (int i = 0; i < board.length; i++) {
                            for (int j = 0; j < board[i].length; j++) {
                                if ((i % 2 == 0 && j % 2 == 0) && (board[i][j] == "" || board[i][j] == null)) {
                                    if (i == 0) {
                                        if(j==0) {
                                            if ((board[i][1] == null || board[i][1] == "") || count==8)
                                                choose_id = ("id_" + i) + j;
                                        }else
                                            if ((board[1][0] == null || board[1][0] == "") || count==8)
                                                choose_id = ("id_" + i) + j;
                                    }
                                    if (i == 2) {
                                        if(j==0) {
                                            if ((board[i][1] == null || board[i][1] == "") || count==8)
                                                choose_id = ("id_" + i) + j;
                                        }else
                                        if ((board[2][0] == null || board[2][0] == "") || count==8)
                                            choose_id = ("id_" + i) + j;
                                    }
                                }
                            }

                        }

                        if(choose_id == null) {
                            for (int i = 0; i < board.length; i++) {
                                for (int j = 0; j < board[i].length; j++) {
                                    if (((i + j % 2) != 0) && (board[i][j] == null || board[i][j] == "")) {
                                        choose_id = ("id_" + i) + j;
                                        break;
                                    }
                                }
                            }
                        }

                    } else if (temp_Xcnt == 0) {

                        for (int i = 0; i < board.length; i++) {
                            if(temp_oCnt>0) {
                                for (int j = 0; j < board[i].length; j++) {
                                    if (((i + j % 2) != 0) && (board[i][j] == null || board[i][j] == "")) {
                                        choose_id = ("id_" + i) + j;
                                        break;
                                    }
                                }
                            }else{
                                Random random = new Random();
                                int p=random.nextInt(1)!=0?0:2;
                                int q=random.nextInt(1)!=0?0:2;
                                choose_id = ("id_" + p) +q;
                                break;
                            }
                            if (choose_id != null)
                                break;
                        }
                    }

                }
            }


        } else if (count == 9) {

            //show the result

            // do vertical check
            int xcount = 0, ocount = 0;
            for (int k = 0; k < board.length; k++) {
                xcount = 0;ocount = 0;
                for (int j = 0; j < board.length; j++) {
                    if (board[k][j] != "0") {
                        ++xcount;
                    } else
                        ++ocount;
                    if (xcount > 2) {
                        machineWon = 1;
                        break;
                    }
                    if (ocount > 2) {
                        machineWon = -1;
                        break;
                    }
                }
                if( machineWon!=0)
                    break;
            }


            // do horizontal check
            if(machineWon==0) {
                for (int k = 0; k < board.length; k++) {
                    xcount = 0;ocount = 0;
                    for (int j = 0; j < board.length; j++) {
                        if (board[j][k] != "0") {
                            ++xcount;
                        } else
                            ++ocount;
                        if (xcount > 2) {
                            machineWon = 1;
                            break;
                        }
                        if (ocount > 2) {
                            machineWon = -1;
                            break;
                        }
                    }
                    if( machineWon!=0)
                        break;
                }
            }

            // left cross check
            if(machineWon==0) {
                xcount = 0;
                ocount = 0;
                for (int k = 0; k < board.length; k++) {
                    if (board[k][k] != "0") {
                        ++xcount;
                    } else
                        ++ocount;
                }
                if (xcount > 2)
                    machineWon = 1;
                if (ocount > 2)
                    machineWon = -1;
            }

            // right cross check
            if(machineWon==0) {
                xcount = 0;
                ocount = 0;
                for (int k = 0; k < board.length; k++) {
                    if (board[k][2 - k] != "0") {
                        ++xcount;
                    } else
                        ++ocount;
                }
                if (xcount > 2) {
                    machineWon = 1;
                }
                if (ocount > 2) {
                    machineWon = -1;
                }
            }

            // toast game draw
            //clearGame();

        } else if(choose_id==null) {
            if(count ==1 && (board[1][1]==null || board[1][1]==""))
                choose_id = "id_11";
            else {
                Random random = new Random();
                int i=random.nextInt(2)!=0?0:2;
                int j=random.nextInt(2)!=0?0:2;
                choose_id = ("id_" + i) +j;
            }

        }

        if(choose_id!=null && machineWon>=0){
            ++count;
            int i = Integer.parseInt(choose_id.substring(choose_id.indexOf("_")+1,choose_id.length()-1));
            int j = Integer.parseInt(choose_id.substring(choose_id.indexOf("_")+2,choose_id.length()));
            board[i][j] = "X";
            int id = getResources().getIdentifier(choose_id, "id", getPackageName());
            TextView views = ((TextView)findViewById(id));
            views.setText("X");
            views.setEnabled(false);
        }
        if(machineWon!=0){
            if(machineWon>0)
                Toast.makeText(getApplicationContext(), "Machine won the game", Toast.LENGTH_LONG).show();  // display a toast message
            if(machineWon<0)
                Toast.makeText(getApplicationContext(),  "You won the game", Toast.LENGTH_LONG).show();  // display a toast message
            clearGame(machineWon);
        }
        else if(count==9){
            Toast.makeText(getApplicationContext(),  "Game draw ", Toast.LENGTH_LONG).show();  // display a toast message
            clearGame(machineWon);
        }
        //   Toast.makeText(getApplicationContext(), "clicj", Toast.LENGTH_LONG).show();  // display a toast message
    }
    // int id = res.getIdentifier("id_", "id", getPackageName());

}

