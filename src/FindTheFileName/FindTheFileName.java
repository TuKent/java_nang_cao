package FindTheFileName;

import java.io.*;
import java.util.ArrayList;

public class FindTheFileName
{
    private File mFolder;
    private File mFile;
    public FindTheFileName (String Folder, String File)
    {
        this.mFolder = new File(Folder);
        this.mFile = new File(File);
    }

}


