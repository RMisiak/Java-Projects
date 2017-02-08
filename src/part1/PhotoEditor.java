package part1;

import becker.xtras.imageTransformation.ITransformations;
import becker.xtras.imageTransformation.ImageTransformerGUI;

public class PhotoEditor extends Object {

    public static void main( String args[] ) {

        ITransformations trans = new Transformer();
        ImageTransformerGUI theGUI = new ImageTransformerGUI( trans );

    }

}
