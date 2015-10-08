package com.example.lebuckle.blender_practice;

        import min3d.core.Object3dContainer;
        import min3d.core.RendererActivity;
        import min3d.objectPrimitives.HollowCylinder;
        import min3d.parser.IParser;
        import min3d.parser.Parser;

/**
 * Example of rendering a 'subset' of index buffer list (list of triangle faces)
 *
 * @author Lee
 */
public class ExampleSubsetOfFaces extends RendererActivity
{
    Object3dContainer _cylinder;
    Object3dContainer objModel;

    int _numFaces,_numFaces2;
    int _faceIndexStart;
    int _faceIndexLength;
    int _incrementer;


    public void initScene()
    {
        /*
        _cylinder = new HollowCylinder(1f, 0.5f, 0.66f, 25);
        _cylinder.scale().setAll(1.2f,1.2f,1.2f);
        _cylinder.normalsEnabled(false);
        _cylinder.vertexColorsEnabled(true);
        _cylinder.doubleSidedEnabled(true);
        scene.addChild(_cylinder);
        */

        IParser parser = Parser.createParser(Parser.Type.OBJ,
                getResources(), "com.example.lebuckle.blender_practice:raw/snowman2_obj", true);
        parser.parse();

        objModel = parser.getParsedObject();
        objModel.scale().x = objModel.scale().y = objModel.scale().z = .2f;
        objModel.normalsEnabled(false);
        objModel.vertexColorsEnabled(true);
        objModel.doubleSidedEnabled(true);
        scene.addChild(objModel);

        //_cylinder.faces().renderSubsetEnabled(true);
        objModel.faces().renderSubsetEnabled(true);

        //_numFaces = _cylinder.faces().size();
        _numFaces2 = objModel.faces().size();

        _faceIndexStart = 0;
        _faceIndexLength = 0;
        _incrementer = +2;
    }

    @Override
    public void updateScene()
    {
        // Update the parameters for rendering subset of cylinder's faces
        //objModel.faces().renderSubsetStartIndex(_faceIndexStart);
        //_cylinder.faces().renderSubsetStartIndex(_faceIndexStart);

        //objModel.faces().renderSubsetLength(_faceIndexLength);
        //_cylinder.faces().renderSubsetLength(_faceIndexLength);

        //_faceIndexLength += _incrementer;

       // if (_faceIndexLength >= _numFaces-1) _incrementer = -2;
        //if (_faceIndexLength <= 0+1) _incrementer = +2;

        //_cylinder.rotation().y += 1.5;
        objModel.rotation().y += 1.5;
    }
}