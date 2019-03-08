package com.example.roushan.satta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.roushan.satta.Chat.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Tablerow extends AppCompatActivity {


    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,
            t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39,
            t40,t41,t42,t43,t44,t45,t46,t47,t48,t49,t50,t51,t52,t53,t54,t55,t56,t57,t58,t59,
            t60,t61,t62,t63,t64,t65,t66,t67,t68,t69,t70,t71,t72,t73,t74,t75,t76,t77,t78,t79,
            t80,t81,t82,t83,t84,t85,t86,t87,t88,t89,
            t90,t91,t92,t93,t94,t95,t96,t97,t98,t99,
            t100,t101,t102,t103,t104,t105,t106,t107,t108,t109,t110,
            t111,t112,t113,t114,t115,t116,t117,t118,t119,
            t120,t121,t122,t123,t124,datetxt;


    FirebaseAuth auth;

    FirebaseDatabase database;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablerow);

        t1=findViewById(R.id.text1);
        t2=findViewById(R.id.text2);
        t3=findViewById(R.id.text3);
        t4=findViewById(R.id.text4);
        t5=findViewById(R.id.text5);
        t6=findViewById(R.id.text6);
        t7=findViewById(R.id.text7);
        t8=findViewById(R.id.text8);
        t9=findViewById(R.id.text9);
        t10=findViewById(R.id.text10);
        t11=findViewById(R.id.text11);
        t12=findViewById(R.id.text12);
        t13=findViewById(R.id.text13);
        t14=findViewById(R.id.text14);
        t15=findViewById(R.id.text15);
        t16=findViewById(R.id.text16);
        t17=findViewById(R.id.text17);
        t18=findViewById(R.id.text18);
        t19=findViewById(R.id.text19);
        t20=findViewById(R.id.text20);
        t21=findViewById(R.id.text21);
        t22=findViewById(R.id.text22);
        t23=findViewById(R.id.text23);
        t24=findViewById(R.id.text24);
        t25=findViewById(R.id.text25);
        t26=findViewById(R.id.text26);
        t27=findViewById(R.id.text27);
        t28=findViewById(R.id.text28);
        t29=findViewById(R.id.text29);
        t30=findViewById(R.id.text30);
        t31=findViewById(R.id.text31);
        t32=findViewById(R.id.text32);
        t33=findViewById(R.id.text33);
        t34=findViewById(R.id.text34);
        t35=findViewById(R.id.text35);
        t36=findViewById(R.id.text36);
        t37=findViewById(R.id.text37);
        t38=findViewById(R.id.text38);
        t39=findViewById(R.id.text39);
        t40=findViewById(R.id.text40);
        t41=findViewById(R.id.text41);
        t42=findViewById(R.id.text42);
        t43=findViewById(R.id.text43);
        t44=findViewById(R.id.text44);
        t45=findViewById(R.id.text45);
        t46=findViewById(R.id.text46);
        t47=findViewById(R.id.text47);
        t48=findViewById(R.id.text48);
        t49=findViewById(R.id.text49);
        t50=findViewById(R.id.text50);
        t51=findViewById(R.id.text51);
        t52=findViewById(R.id.text52);
        t53=findViewById(R.id.text53);
        t54=findViewById(R.id.text54);
        t55=findViewById(R.id.text55);
        t56=findViewById(R.id.text56);
        t57=findViewById(R.id.text57);
        t58=findViewById(R.id.text58);
        t59=findViewById(R.id.text59);
        t60=findViewById(R.id.text60);
        t61=findViewById(R.id.text61);
        t62=findViewById(R.id.text62);
        t63=findViewById(R.id.text63);
        t64=findViewById(R.id.text64);
        t65=findViewById(R.id.text65);
        t66=findViewById(R.id.text66);
        t67=findViewById(R.id.text67);
        t68=findViewById(R.id.text68);
        t69=findViewById(R.id.text69);
        t70=findViewById(R.id.text70);
        t71=findViewById(R.id.text71);
        t72=findViewById(R.id.text72);
        t73=findViewById(R.id.text73);
        t74=findViewById(R.id.text74);
        t75=findViewById(R.id.text75);
        t76=findViewById(R.id.text76);
        t77=findViewById(R.id.text77);
        t78=findViewById(R.id.text78);
        t79=findViewById(R.id.text79);
        t80=findViewById(R.id.text80);
        t81=findViewById(R.id.text81);
        t82=findViewById(R.id.text82);
        t83=findViewById(R.id.text83);
        t84=findViewById(R.id.text84);
        t85=findViewById(R.id.text85);
        t86=findViewById(R.id.text86);
        t87=findViewById(R.id.text87);
        t88=findViewById(R.id.text88);
        t89=findViewById(R.id.text89);
        t90=findViewById(R.id.text90);
        t91=findViewById(R.id.text91);
        t92=findViewById(R.id.text92);
        t93=findViewById(R.id.text93);
        t94=findViewById(R.id.text94);
        t95=findViewById(R.id.text95);
        t96=findViewById(R.id.text96);
        t97=findViewById(R.id.text97);
        t98=findViewById(R.id.text98);
        t99=findViewById(R.id.text99);
        t100=findViewById(R.id.text100);
        t101=findViewById(R.id.text101);
        t102=findViewById(R.id.text102);
        t103=findViewById(R.id.text103);
        t104=findViewById(R.id.text104);
        t105=findViewById(R.id.text105);
        t106=findViewById(R.id.text106);
        t107=findViewById(R.id.text107);
        t108=findViewById(R.id.text108);
        t109=findViewById(R.id.text109);
        t110=findViewById(R.id.text110);
        t111=findViewById(R.id.text111);
        t112=findViewById(R.id.text112);
        t113=findViewById(R.id.text113);
        t114=findViewById(R.id.text114);
        t115=findViewById(R.id.text115);
        t116=findViewById(R.id.text116);
        t117=findViewById(R.id.text117);
        t118=findViewById(R.id.text118);
        t119=findViewById(R.id.text119);
        t120=findViewById(R.id.text120);
        t121=findViewById(R.id.text121);
        t122=findViewById(R.id.text122);
        t123=findViewById(R.id.text123);
        t124=findViewById(R.id.text124);
        datetxt=findViewById(R.id.textView14);


        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        mRef=database.getReference().child("SATTARESULT");





        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                t1.setText(String.valueOf(map.get("1DA")));
                t2.setText(String.valueOf(map.get("1FA")));
                t3.setText(String.valueOf(map.get("1GZB")));
                t4.setText(String.valueOf(map.get("1GAL")));

                t5.setText(String.valueOf(map.get("2DA")));
                t6.setText(String.valueOf(map.get("2FA")));
                t7.setText(String.valueOf(map.get("2GZB")));
                t8.setText(String.valueOf(map.get("2GAL")));

                t9.setText(String.valueOf(map.get("3DA")));
                t10.setText(String.valueOf(map.get("3FA")));
                t11.setText(String.valueOf(map.get("3GZB")));
                t12.setText(String.valueOf(map.get("3GAL")));

                t13.setText(String.valueOf(map.get("4DA")));
                t14.setText(String.valueOf(map.get("4FA")));
                t15.setText(String.valueOf(map.get("4GZB")));
                t16.setText(String.valueOf(map.get("4GAL")));

                t17.setText(String.valueOf(map.get("5DA")));
                t18.setText(String.valueOf(map.get("5FA")));
                t19.setText(String.valueOf(map.get("5GZB")));
                t20.setText(String.valueOf(map.get("5GAL")));

                t21.setText(String.valueOf(map.get("6DA")));
                t22.setText(String.valueOf(map.get("6FA")));
                t23.setText(String.valueOf(map.get("6GZB")));
                t24.setText(String.valueOf(map.get("6GAL")));

                t25.setText(String.valueOf(map.get("7DA")));
                t26.setText(String.valueOf(map.get("7FA")));
                t27.setText(String.valueOf(map.get("7GZB")));
                t28.setText(String.valueOf(map.get("7GAL")));

                t29.setText(String.valueOf(map.get("8DA")));
                t30.setText(String.valueOf(map.get("8FA")));
                t31.setText(String.valueOf(map.get("8GZB")));
                t32.setText(String.valueOf(map.get("8GAL")));

                t33.setText(String.valueOf(map.get("9DA")));
                t34.setText(String.valueOf(map.get("9FA")));
                t35.setText(String.valueOf(map.get("9GZB")));
                t36.setText(String.valueOf(map.get("9GAL")));

                t37.setText(String.valueOf(map.get("10DA")));
                t38.setText(String.valueOf(map.get("10FA")));
                t39.setText(String.valueOf(map.get("10GZB")));
                t40.setText(String.valueOf(map.get("10GAL")));
                t41.setText(String.valueOf(map.get("11DA")));
                t42.setText(String.valueOf(map.get("11FA")));
                t43.setText(String.valueOf(map.get("11GZB")));
                t44.setText(String.valueOf(map.get("11GAL")));

                t45.setText(String.valueOf(map.get("12DA")));
                t46.setText(String.valueOf(map.get("12FA")));
                t47.setText(String.valueOf(map.get("12GZB")));
                t48.setText(String.valueOf(map.get("12GAL")));


                t49.setText(String.valueOf(map.get("13DA")));
                t50.setText(String.valueOf(map.get("13FA")));
                t51.setText(String.valueOf(map.get("13GZB")));
                t52.setText(String.valueOf(map.get("13GAL")));


                t53.setText(String.valueOf(map.get("14DA")));
                t54.setText(String.valueOf(map.get("14FA")));
                t55.setText(String.valueOf(map.get("14GZB")));
                t56.setText(String.valueOf(map.get("14GAL")));


                t57.setText(String.valueOf(map.get("15DA")));
                t58.setText(String.valueOf(map.get("15FA")));
                t59.setText(String.valueOf(map.get("15GZB")));
                t60.setText(String.valueOf(map.get("15GAL")));

                t61.setText(String.valueOf(map.get("16DA")));
                t62.setText(String.valueOf(map.get("16FA")));
                t63.setText(String.valueOf(map.get("16GZB")));
                t64.setText(String.valueOf(map.get("16GAL")));

                t65.setText(String.valueOf(map.get("17DA")));
                t66.setText(String.valueOf(map.get("17FA")));
                t67.setText(String.valueOf(map.get("17GZB")));
                t68.setText(String.valueOf(map.get("17GAL")));

                t69.setText(String.valueOf(map.get("18DA")));
                t70.setText(String.valueOf(map.get("18FA")));
                t71.setText(String.valueOf(map.get("18GZB")));
                t72.setText(String.valueOf(map.get("18GAL")));

                t73.setText(String.valueOf(map.get("19DA")));
                t74.setText(String.valueOf(map.get("19FA")));
                t75.setText(String.valueOf(map.get("19GZB")));
                t76.setText(String.valueOf(map.get("19GAL")));

                t77.setText(String.valueOf(map.get("20DA")));
                t78.setText(String.valueOf(map.get("20FA")));
                t79.setText(String.valueOf(map.get("20GZB")));
                t80.setText(String.valueOf(map.get("20GAL")));

                t81.setText(String.valueOf(map.get("21DA")));
                t82.setText(String.valueOf(map.get("21FA")));
                t83.setText(String.valueOf(map.get("21GZB")));
                t84.setText(String.valueOf(map.get("21GAL")));

                t85.setText(String.valueOf(map.get("22DA")));
                t86.setText(String.valueOf(map.get("22FA")));
                t87.setText(String.valueOf(map.get("22GZB")));
                t88.setText(String.valueOf(map.get("22GAL")));

                t89.setText(String.valueOf(map.get("23DA")));
                t90.setText(String.valueOf(map.get("23FA")));
                t91.setText(String.valueOf(map.get("23GZB")));
                t92.setText(String.valueOf(map.get("23GAL")));

                t93.setText(String.valueOf(map.get("24DA")));
                t94.setText(String.valueOf(map.get("24FA")));
                t95.setText(String.valueOf(map.get("24GZB")));
                t96.setText(String.valueOf(map.get("24GAL")));

                t97.setText(String.valueOf(map.get("25DA")));
                t98.setText(String.valueOf(map.get("25FA")));
                t99.setText(String.valueOf(map.get("25GZB")));
                t100.setText(String.valueOf(map.get("25GAL")));


                t101.setText(String.valueOf(map.get("26DA")));
                t102.setText(String.valueOf(map.get("26FA")));
                t103.setText(String.valueOf(map.get("26GZB")));
                t104.setText(String.valueOf(map.get("26GAL")));

                t105.setText(String.valueOf(map.get("27DA")));
                t106.setText(String.valueOf(map.get("27FA")));
                t107.setText(String.valueOf(map.get("27GZB")));
                t108.setText(String.valueOf(map.get("27GAL")));


                t109.setText(String.valueOf(map.get("28DA")));
                t110.setText(String.valueOf(map.get("28FA")));
                t111.setText(String.valueOf(map.get("28GZB")));
                t112.setText(String.valueOf(map.get("28GAL")));

                t113.setText(String.valueOf(map.get("29DA")));
                t114.setText(String.valueOf(map.get("29FA")));
                t115.setText(String.valueOf(map.get("29GZB")));
                t116.setText(String.valueOf(map.get("29GAL")));

                t117.setText(String.valueOf(map.get("30DA")));
                t118.setText(String.valueOf(map.get("30FA")));
                t119.setText(String.valueOf(map.get("30GZB")));
                t120.setText(String.valueOf(map.get("30GAL")));
                t121.setText(String.valueOf(map.get("31DA")));
                t122.setText(String.valueOf(map.get("31FA")));
                t123.setText(String.valueOf(map.get("31GZB")));
                t124.setText(String.valueOf(map.get("31GAL")));

                datetxt.setText(String.valueOf(map.get("MONTH")));





            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });




    }
}
