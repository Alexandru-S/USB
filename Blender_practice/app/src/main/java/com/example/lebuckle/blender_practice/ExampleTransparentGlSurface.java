package com.example.lebuckle.blender_practice;

        import min3d.core.Object3dContainer;
        import min3d.core.RendererActivity;
        import min3d.objectPrimitives.Box;
        import min3d.parser.IParser;
        import min3d.parser.Parser;
        import min3d.vos.Light;
        import android.graphics.PixelFormat;
        import android.os.Bundle;
        import android.view.View;

/**
 * Example of implementing a transparent GLSurfaceView.
 *
 * 	(a) Override glSurfaceViewConfig() to configure glSurfaceView for transparency as shown
 * 	(b) Set the scene's backgroundColor to 0x00000000 (black with 0-alpha)
 *
 * If you were to place any 2D elements (images, etc) in the Activity "behind" glSurface,
 * they would be now visible.
 *
 * In this example, instead of doing that, the Activity itself is set to transparent,
 * allowing the underlying Activity to show through... (See the manifest xml --
 * "android:theme="@android:style/Theme.Translucent.NoTitleBar")
 *
 * @author Lee
 */
public class ExampleTransparentGlSurface extends RendererActivity
{
    private final int NUM = 25;

    private Box[] boxes;
    private Object3dContainer objModel, objModel1, objModel2, objModel3, objModel4;


    @Override
    protected void glSurfaceViewConfig()
    {
        // !important
        _glSurfaceView.setEGLConfigChooser(8,8,8,8, 16, 0);
        _glSurfaceView.getHolder().setFormat(PixelFormat.TRANSLUCENT);
    }

    @Override
    public void initScene()
    {
        // !important
        scene.backgroundColor().setAll(0x00000000);

        Light light = new Light();
        scene.lights().add(light);

        //********************************
        //************************************
        IParser parser2 = Parser.createParser(Parser.Type.OBJ,
                getResources(), "com.example.lebuckle.blender_practice:raw/snowflake2_obj", true);
        parser2.parse();

        objModel2 = parser2.getParsedObject();
        objModel2.scale().x = objModel2.scale().y = objModel2.scale().z = 0.6f;
        objModel2.position().x = (float) (-1.5 + Math.random()*2);
        objModel2.position().y = (float) (-4 + Math.random()*8);
        objModel2.position().z = (float) (-1.5 + Math.random()*3);
        objModel2.rotation().x = (float) (Math.random()*360);
        objModel2.rotation().y = (float) (Math.random()*360);
        scene.addChild(objModel2);

        IParser parser = Parser.createParser(Parser.Type.OBJ,
                getResources(), "com.example.lebuckle.blender_practice:raw/snowflake2_obj", true);
        parser.parse();

        objModel = parser.getParsedObject();
        objModel.scale().x = objModel.scale().y = objModel.scale().z = 0.6f;
        objModel.position().x = (float) (-1.5 + Math.random()*2);
        objModel.position().y = (float) (-4 + Math.random()*8);
        objModel.position().z = (float) (-1.5 + Math.random()*3);
        objModel.rotation().x = (float) (Math.random()*360);
        objModel.rotation().y = (float) (Math.random()*360);
        scene.addChild(objModel);

        IParser parser1 = Parser.createParser(Parser.Type.OBJ,
                getResources(), "com.example.lebuckle.blender_practice:raw/snowflake2_obj", true);
        parser1.parse();

        objModel1 = parser1.getParsedObject();
        objModel.scale().x = objModel1.scale().y = objModel1.scale().z = 0.6f;
        objModel1.position().x = (float) (-1.5 + Math.random()*2);
        objModel1.position().y = (float) (-4 + Math.random()*8);
        objModel1.position().z = (float) (-1.5 + Math.random()*3);
        objModel1.rotation().x = (float) (Math.random()*360);
        objModel1.rotation().y = (float) (Math.random()*360);
        scene.addChild(objModel1);

        IParser parser3 = Parser.createParser(Parser.Type.OBJ,
                getResources(), "com.example.lebuckle.blender_practice:raw/snowflake2_obj", true);
        parser3.parse();

        objModel3 = parser3.getParsedObject();
        objModel3.scale().x = objModel3.scale().y = objModel3.scale().z = 0.6f;
        objModel3.position().x = (float) (-1.5 + Math.random()*2);
        objModel3.position().y = (float) (-4 + Math.random()*8);
        objModel3.position().z = (float) (-1.5 + Math.random()*3);
        objModel3.rotation().x = (float) (Math.random()*360);
        objModel3.rotation().y = (float) (Math.random()*360);
        scene.addChild(objModel3);

        IParser parser4 = Parser.createParser(Parser.Type.OBJ,
                getResources(), "com.example.lebuckle.blender_practice:raw/snowflake2_obj", true);
        parser4.parse();

        objModel4 = parser4.getParsedObject();
        objModel4.scale().x = objModel4.scale().y = objModel4.scale().z = 0.6f;
        objModel4.position().x = (float) (-1.5 + Math.random()*2);  //was 3
        objModel4.position().y = (float) (-4 + Math.random()*8);
        objModel4.position().z = (float) (-1.5 + Math.random()*3);
        objModel4.rotation().x = (float) (Math.random()*360);
        objModel4.rotation().y = (float) (Math.random()*360);
        scene.addChild(objModel4);


        //**********************************************
        //************************************************************

        boxes = new Box[NUM];
        for (int i = 0; i < NUM; i++) {
            Box box = new Box(0.2f,0.2f,0.2f);
            box.vertexColorsEnabled(false);
            box.position().x = (float) (-1.5 + Math.random()*3);
            box.position().y = (float) (-4 + Math.random()*8);
            box.position().z = (float) (-1.5 + Math.random()*3);
            box.rotation().x = (float) (Math.random()*360);
            box.rotation().y = (float) (Math.random()*360);
            boxes[i] = box;
            scene.addChild(box);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        _glSurfaceView.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

    }

    @Override
    public void updateScene()
    {

        for (int i = 0; i < NUM; i++) {
            boxes[i].rotation().x += 2;
            boxes[i].rotation().y += 1;
            boxes[i].position().y -= .040;
            if (boxes[i].position().y < -4) {
                boxes[i].position().y = 4;
                boxes[i].position().x = (float) (-1.5 + Math.random()*3);
                boxes[i].position().z = (float) (-1.5 + Math.random()*3);
            }
        }


            objModel.rotation().x += 2;
            objModel.rotation().y += 1;
            objModel.position().y -= .020;
            if (objModel.position().y < -4) {
                objModel.position().y = 4;
                objModel.position().x = (float) (-1.5 + Math.random() * 3);
                objModel.position().z = (float) (-1.5 + Math.random() * 3);
            }

            objModel1.rotation().x += 2;
            objModel1.rotation().y += 1;
            objModel1.position().y -= .020;
            if (objModel1.position().y < -4) {
                objModel1.position().y = 4;
                objModel1.position().x = (float) (-1.5 + Math.random() * 3);
                objModel1.position().z = (float) (-1.5 + Math.random() * 3);
            }

            objModel2.rotation().x += 2;
            objModel2.rotation().y += 1;
            objModel2.position().y -= .020;
            if (objModel2.position().y < -4) {
                objModel2.position().y = 4;
                objModel2.position().x = (float) (-1.5 + Math.random() * 3);
                objModel2.position().z = (float) (-1.5 + Math.random() * 3);
            }

            objModel3.rotation().x += 2;
            objModel3.rotation().y += 1;
            objModel3.position().y -= .020;
            if (objModel3.position().y < -4) {
                objModel3.position().y = 4;
                objModel3.position().x = (float) (-1.5 + Math.random() * 3);
                objModel3.position().z = (float) (-1.5 + Math.random() * 3);
            }

            objModel4.rotation().x += 2;
            objModel4.rotation().y += 1;
            objModel4.position().y -= .020;
            if (objModel4.position().y < -4) {
                objModel4.position().y = 4;
                objModel4.position().x = (float) (-1.5 + Math.random() * 3);
                objModel4.position().z = (float) (-1.5 + Math.random() * 3);
            }


        objModel.rotation().x += 2;
        objModel.rotation().y += 1;
        objModel.position().y -= .020;
        if (objModel.position().y < -4) {
            objModel.position().y = 4;
            objModel.position().x = (float) (-1.5 + Math.random() * 3);
            objModel.position().z = (float) (-1.5 + Math.random() * 3);
        }

        objModel1.rotation().x += 2;
        objModel1.rotation().y += 1;
        objModel1.position().y -= .020;
        if (objModel1.position().y < -4) {
            objModel1.position().y = 4;
            objModel1.position().x = (float) (-1.5 + Math.random() * 3);
            objModel1.position().z = (float) (-1.5 + Math.random() * 3);
        }

        objModel2.rotation().x += 2;
        objModel2.rotation().y += 1;
        objModel2.position().y -= .020;
        if (objModel2.position().y < -4) {
            objModel2.position().y = 4;
            objModel2.position().x = (float) (-1.5 + Math.random() * 3);
            objModel2.position().z = (float) (-1.5 + Math.random() * 3);
        }

        objModel3.rotation().x += 2;
        objModel3.rotation().y += 1;
        objModel3.position().y -= .020;
        if (objModel3.position().y < -4) {
            objModel3.position().y = 4;
            objModel3.position().x = (float) (-1.5 + Math.random() * 3);
            objModel3.position().z = (float) (-1.5 + Math.random() * 3);
        }

        objModel4.rotation().x += 2;
        objModel4.rotation().y += 1;
        objModel4.position().y -= .020;
        if (objModel4.position().y < -4) {
            objModel4.position().y = 4;
            objModel4.position().x = (float) (-1.5 + Math.random() * 3);
            objModel4.position().z = (float) (-1.5 + Math.random() * 3);
        }

        objModel.rotation().x += 2;
        objModel.rotation().y += 1;
        objModel.position().y -= .020;
        if (objModel.position().y < -4) {
            objModel.position().y = 4;
            objModel.position().x = (float) (-1.5 + Math.random() * 3);
            objModel.position().z = (float) (-1.5 + Math.random() * 3);
        }

        objModel2.rotation().x += 2;
        objModel1.rotation().y += 1;
        objModel1.position().y -= .020;
        if (objModel1.position().y < -4) {
            objModel1.position().y = 4;
            objModel1.position().x = (float) (-1.5 + Math.random() * 3);
            objModel1.position().z = (float) (-1.5 + Math.random() * 3);
        }

        objModel4.rotation().x += 2;
        objModel2.rotation().y += 1;
        objModel2.position().y -= .020;
        if (objModel2.position().y < -4) {
            objModel2.position().y = 4;
            objModel2.position().x = (float) (-1.5 + Math.random() * 3);
            objModel2.position().z = (float) (-1.5 + Math.random() * 3);
        }

        objModel3.rotation().x += 2;
        objModel3.rotation().y += 1;
        objModel3.position().y -= .020;
        if (objModel3.position().y < -4) {
            objModel3.position().y = 4;
            objModel3.position().x = (float) (-1.5 + Math.random() * 3);
            objModel3.position().z = (float) (-1.5 + Math.random() * 3);
        }

        objModel4.rotation().x += 2;
        objModel4.rotation().y += 1;
        objModel4.position().y -= .020;  //was 0.075
        if (objModel4.position().y < -4) {
            objModel4.position().y = 4;
            objModel4.position().x = (float) (-1.5 + Math.random() * 3);
            objModel4.position().z = (float) (-1.5 + Math.random() * 3);
        }



    }
}