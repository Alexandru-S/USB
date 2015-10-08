package com.example.lebuckle.blender_practice;

        import android.graphics.Bitmap;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.LinearLayout;

        import min3d.Shared;
        import min3d.Utils;
        import min3d.core.Object3dContainer;
        import min3d.core.RendererActivity;
        import min3d.objectPrimitives.Sphere;
        import min3d.parser.IParser;
        import min3d.parser.Parser;
        import min3d.vos.Light;
        import min3d.vos.Number3d;

/**
 * How to load a model from a .obj file
 *
 * @author dennis.ippel
 *
 */
public class ExampleLoadObjFile extends RendererActivity {
    private Object3dContainer objModel,objModel2;
    private Object3dContainer _jupiter;
    int _count;

    //*****************
    Number3d _defaultPosUL;
    Number3d _defaultPosLR;
    //****************


    @Override
    protected void onCreateSetContentView() {
        setContentView(R.layout.keyframe_anim_layout);

        LinearLayout ll = (LinearLayout) this.findViewById(R.id.scene2Holder);
        ll.addView(_glSurfaceView);
        ll.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, final MotionEvent event) {

                int eventaction = event.getAction();
                float posx, posx2;
                float posy, posy2;
                float midpoint;
                float x1 = objModel.position().x;
                float y1 = objModel.position().y;
                float z1 = objModel.position().z;

                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN:
                        posx = event.getX();
                        posy = event.getY();
                        // finger touches the screen
                        break;

                    case MotionEvent.ACTION_MOVE:
                        // finger moves on the screen
                            posy = event.getY();
                           objModel.rotation().y = posy;
                        break;

                    case MotionEvent.ACTION_UP:
                        // finger leaves the screen
                         posx2 = event.getX();
                         posy2 = event.getY();




                        if(posx2 > 500.0f && posy2  >1000.0f)
                        {
                            posx2 = posx2/1000;
                            posy2 = -posy2/1000;
                            objModel.position().x = posx2;
                            objModel.position().y = posy2;
                            //bottom right

                        }
                        if(posx2 <500.0f && posy2 >1000.0f)
                        {
                            posx2 = -(posx2+300)/1000;
                            posy2 = -posy2/1000;

                            objModel.position().x = posx2;
                            objModel.position().y = posy2;
                            //bottom left
                        }


                        if(posx2 > 500.0f && posy2  <1000.0f)
                        {
                            posx2 = posx2/1000;
                            posy2 = (1000-posy2)/1000;
                            objModel.position().x = posx2;
                            objModel.position().y = posy2;

                            //top right
                        }





                        /*
                        if(posx2 < 500.0f && posy2 <1000.0f)
                        {
                            posx2 = -posx2/1000;
                            posy2 = (1000-posy2)/1000;

                            objModel.position().x = posx2;
                            objModel.position().y = posy2;
                            //top left
                        }
                        */



                        /*

                        if(posx2 > +500.0f)
                        {

                            //objModel.rotation().y =posy2;
                            //objModel.position().y =posx;
                            if(x1<1.1f) {
                                //objModel.position().x++;
                            }


                        }
                        if(posx2 < +500.0f)
                        {
                            //objModel.rotation().x =posx2;
                            if(x1>-0.50f) {
                               // objModel.position().x--;
                            }
                        }
                        if(posy2 <200.0f)
                        {
                            //float newy = 0.1f;
                            //objModel.rotation().y =posy2;
                            //objModel.position().y =posx;
                            if(y1<1.5f) {
                                //objModel.position().y++;
                            }
                            //objModel.rotation().y = posy2;


                        }
                       // if(posy2 > 100.0f)
                       // {
                            //objModel.rotation().x =posx2;
                           // objModel.position().y--;
                       // }

                        if(posy2 >1600.0f)
                        {
                           // float newy = 0.1f;
                            //objModel.rotation().y = posy2;
                            if(y1>-2.0f) {
                                //objModel.position().y--;
                                 }
                        }
                        */






                        break;
                }



                /*
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    //objModel.rotation().y += .100f;
                    float posx = event.getX();
                    float posy = event.getY();

                    //objModel.rotation().x = posx;
                    objModel.rotation().y = posy;

                } if(event.getAction() == MotionEvent.ACTION_DOWN )
                {
                    float posx = event.getX();
                    float posy = event.getY();
                    objModel.position().x = posx;
                    objModel.position().y = posy;

                }
                */


                return true;  //originally false
            }


        });
    }






    @Override
    public void initScene() {

        scene.lights().add(new Light());

        IParser parser = Parser.createParser(Parser.Type.OBJ,
                getResources(), "com.example.lebuckle.blender_practice:raw/minion_obj", true);
        parser.parse();

        objModel = parser.getParsedObject();
        objModel.scale().x = objModel.scale().y = objModel.scale().z = .3f;
         //new
          objModel.position().x = 0.1f;
          objModel.position().y = 0.1f;

         // objModel.position().z = 0.0f;
        //
        scene.addChild(objModel);

        //IParser parser2 = Parser.createParser(Parser.Type.OBJ,
         //       getResources(), "com.example.lebuckle.blender_practice:raw/snowflake2_obj", true);
        //parser2.parse();

       // objModel2 = parser2.getParsedObject();
        //objModel2.scale().x = objModel2.scale().y = objModel2.scale().z = 0.2f;
        //new
       //objModel2.position().x = 1.0f;
        //objModel.position().z = 1f;
        //
        //scene.addChild(objModel2);


        //  _jupiter = new Sphere(0.2f, 10, 8,  true,true,false);
       //_jupiter.position().x = 1.6f;
       // _jupiter.rotation().x = 23;
      //  objModel.addChild(_jupiter);

        //new
        //_jupiter = new Sphere(.8f, 12, 9);
        //_jupiter.position().x = +0.4f;
        // scene.addChild(_jupiter);

        // Add textures to TextureManager
       // Bitmap b = Utils.makeBitmapFromResourceId(this, R.drawable.jupiter);
        //Shared.textureManager().addTextureId(b, "jupiter", true);
       // b.recycle();

        //_jupiter.textures().addById("jupiter");
        _count =0;
    }

    @Override
    public void updateScene() {
        //objModel.rotation().x++;
        //objModel.rotation().z++;
        //objModel.rotation().y += 1.0f;
        //objModel.rotation().x -= .4f;
        //objModel.rotation().y -= .6f;
       // objModel2.rotation().y -= .6f;
       //_jupiter.rotation().y += 3;



        //_jupiter.rotation().y += 1.0f;
       // _count++;
      //  float mag = (float)(Math.sin(_count*0.2*Utils.DEG)) * 15;
        //_jupiter.rotation().z = (float)Math.sin(_count*.33*Utils.DEG) * mag;


        // Move camera around
        //scene.camera().position.z = 4.5f + (float)Math.sin(_jupiter.rotation().y * Utils.DEG);
       // scene.camera().target.x = (float)Math.sin((_jupiter.rotation().y + 90) * Utils.DEG) * 0.8f;

    }
}