package com.example.lebuckle.blender_practice;

        import min3d.Shared;
        import min3d.Utils;
        import min3d.core.Object3dContainer;
        import min3d.core.RendererActivity;
        import min3d.objectPrimitives.Sphere;
        import min3d.parser.IParser;
        import min3d.parser.Parser;
        import min3d.vos.Light;
        import min3d.vos.TextureVo;
        import android.graphics.Bitmap;

/**
 * Shows how objects can be assigned textures dynamically.
 *
 * Also demonstrates how the same "textureId" can be assigned to multiple objects
 * (rather than, say, needing to create two instances of a texture
 * for two separate objects)
 */
public class ExampleAssigningTexturesDynamically extends RendererActivity
{
    Object3dContainer _object1;
    Object3dContainer _object2;
    Object3dContainer objModel;
    Object3dContainer objModel2;

    TextureVo _jupiterTexture;
    TextureVo _earthTexture;
    TextureVo _moonTexture;

    int _count;


    public void initScene()
    {
        scene.lights().add(new Light());

        // Add three textures to TextureManager
        /*
        Bitmap b;

        b = Utils.makeBitmapFromResourceId(R.drawable.jupiter);
        Shared.textureManager().addTextureId(b, "jupiter", false);
        b.recycle();

        b = Utils.makeBitmapFromResourceId(R.drawable.earth);
        Shared.textureManager().addTextureId(b, "earth", false);
        b.recycle();

        b = Utils.makeBitmapFromResourceId(R.drawable.moon);
        Shared.textureManager().addTextureId(b, "moon", false);
        b.recycle();

        */
        //*************************
        //*********************


        IParser parser = Parser.createParser(Parser.Type.OBJ,
                getResources(), "com.example.lebuckle.blender_practice:raw/minion_obj", true);
        parser.parse();

        objModel = parser.getParsedObject();
        objModel.scale().x = objModel.scale().y = objModel.scale().z = .3f;
        //scene.addChild(objModel);

        IParser parser2 = Parser.createParser(Parser.Type.OBJ,
                getResources(), "com.example.lebuckle.blender_practice:raw/snowman2_obj", true);
        parser2.parse();

        objModel2 = parser2.getParsedObject();
        objModel2.scale().x = objModel2.scale().y = objModel2.scale().z = .3f;


        //**********************************
        //*************************************

        // Create three TextureVo's
         /*
        _jupiterTexture = new TextureVo("jupiter");
        _earthTexture = new TextureVo("earth");
        _moonTexture = new TextureVo("moon");

        _object1 = new Sphere(0.8f, 15, 10);
        _object1.position().y = 0.9f;
        scene.addChild(_object1);

        _object2 = new Sphere(0.8f, 15, 10);
        _object2.position().y = -0.9f;
        scene.addChild(_object2);

        */
        objModel.position().y = 0.9f;
        scene.addChild(objModel);

        objModel2.position().y = -0.9f;
        //objModel2.position().x = -0.9f;
        //objModel2.rotation().x = -0.9f;
        scene.addChild(objModel2);

        _count = 0;
    }

    @Override
    public void updateScene()
    {
        _count++;

        // Assign a different texture to the two objects
        // every second or so
        /*
        if (_count % 240 == 0) {
            _object1.textures().clear(); // ie, no texture
            _object2.textures().clear();
        }
        else if (_count % 240 == 60) {
            _object1.textures().addReplace(_jupiterTexture);
            _object2.textures().addReplace(_jupiterTexture);
        }
        else if (_count % 240 == 120) {
            _object1.textures().addReplace(_earthTexture);
            _object2.textures().addReplace(_earthTexture);
        }
        else if (_count % 240 == 180) {
            _object1.textures().addReplace(_moonTexture);
            _object2.textures().addReplace(_moonTexture);
        }
        */
        //_object1.rotation().y +=1;
       // _object2.rotation().y -=1;

        objModel.rotation().y +=1;
        objModel2.rotation().y -=1;
    }
}