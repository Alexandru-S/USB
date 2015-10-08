package com.example.lebuckle.blender_practice;

        import min3d.core.Object3dContainer;
        import min3d.core.RendererActivity;
        import min3d.objectPrimitives.Box;
        import min3d.parser.IParser;
        import min3d.parser.Parser;
        import min3d.vos.Light;

        import android.content.Intent;
        import android.view.View;
        import android.widget.Button;
        import android.widget.LinearLayout;
        import android.view.View.OnTouchListener;
        import android.view.GestureDetector;
        import android.view.MotionEvent;

/**
 * Example of adding an OpenGL scene within a conventional Android application layout.
 * Entails overriding RenderActivity's onCreateSetContentView() function, and
 * adding _glSurfaceView to the appropriate View...
 *
 * @author Lee
 */
public class ExampleInsideLayout extends RendererActivity implements View.OnClickListener
{
    Object3dContainer _cube;
    private Object3dContainer objModel;
    Button b, c, d, e, f,g, h;
    boolean right, left;
    int countL=0;
    int countR=0;
    float mPreviousX, mPreviousY;
    LinearLayout z;
    int x,y;



    @Override
    protected void onCreateSetContentView()
    {
        setContentView(R.layout.custom_layout_example);

        LinearLayout ll = (LinearLayout) this.findViewById(R.id.scene1Holder);
        ll.addView(_glSurfaceView);
        ll.setOnTouchListener(new View.OnTouchListener(){

            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_MOVE) {
                    //objModel.rotation().y += .100f;

                    float posx = event.getX();
                    float posy = event.getY();


                    //objModel.rotation().x = posx;
                    objModel.rotation().y = posy;

                }
                /*if(event.getAction() == MotionEvent.ACTION_UP )
                {
                    float posx = event.getX();
                    objModel.rotation().x = posx;

                }
                */



                return true;  //originally false
            }
            public boolean onPinchPointersDown(MotionEvent event) {
                float posx = event.getX();
                float posy ;
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                 objModel.rotation().x = posx;

                return true;
            }


        });

        right =false;
        left =false;


        b = (Button) this.findViewById(R.id.layoutOkay);
        b.setOnClickListener(this);
        c = (Button) this.findViewById(R.id.layoutCancel);
        c.setOnClickListener(this);
        d = (Button) this.findViewById(R.id.snow);
        d.setOnClickListener(this);

        e = (Button) this.findViewById(R.id.button);
        e.setOnClickListener(this);
        f = (Button) this.findViewById(R.id.button2);
        f.setOnClickListener(this);
        g = (Button) this.findViewById(R.id.button3);
        g.setOnClickListener(this);
        h = (Button) this.findViewById(R.id.button4);
        h.setOnClickListener(this);



        //.setOnClickListener(
    }

    public void onClick(View $v)
    {
        if($v == b) {
            //this.startActivity(new Intent(this, ExampleTransparentGlSurface.class));
            //_cube.rotation().y++;
            left = true;
            right =false;
            countL = countL+1;
            countR =0;

        }
        if($v == c) {
           // finish();
           // _cube.rotation().y--;
            left = false;
            right =true;
            countR =countR + 1;
            countL =0;

        }
        if($v == d) {
            this.startActivity(new Intent(this, ExampleTransparentGlSurface.class));
        }
        if($v == e) {
            objModel.position().y++;
        }
        if($v == f) {
            objModel.position().y--;
        }
        if($v == g) {
            objModel.position().x--;
        }
        if($v == h) {
            objModel.position().x++;
        }

     }

    //

    public void initScene()
    {
        scene.lights().add(new Light());

        scene.backgroundColor().setAll(0xff444444);
       //
       //_cube = new Box(1,1,1);
       // scene.addChild(_cube);
        IParser parser = Parser.createParser(Parser.Type.OBJ,
               getResources(), "com.example.lebuckle.blender_practice:raw/snowman2_obj", true);
        parser.parse();

        objModel = parser.getParsedObject();
        objModel.scale().x = objModel.scale().y = objModel.scale().z = .2f;
        scene.addChild(objModel);



    }

    @Override
    public void updateScene() {
        //_cube.rotation().y++;
        if (!right && !left) {

        }
        if (right && !left) {
            //_cube.rotation().y++;
            //objModel.rotation().y++;
            objModel.rotation().y += .6f;
            if (countR >= 1) {
                objModel.rotation().y += .12f;
            }
        }
        if (!right && left) {
            //_cube.rotation().y--;
            //objModel.rotation().y--;
            objModel.rotation().y -= .6f;
            if (countL >= 1) {
                objModel.rotation().y += .12f;
            }
        }
    }





}
