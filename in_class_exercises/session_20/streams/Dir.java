import java.io.File;

/** Demonstration der Klasse File. */
class Dir
{
    /**
     * Listet alle Dateien und Verzeichnisse innerhalb eines Verzeichnisses auf.
     * @param path Der Pfad zu dem Verzeichnis dessen Inhalt angezeigt werden soll.
     */
    static void dir(final String path)
    {
        System.out.println(dir(new File(path), ""));
    }

    /**
     * Listet eine Datei oder ein Verzeichnis auf. Dabei werden verschachtelte
     *                    Strukturen unterschiedlich weit eingerückt dargestellt.
     * @param file        Die Datei oder das Verzeichnis, die angezeigt werden.
     *                    Ist dies ein Verzeichnis, werden allen enthaltenen
     *                    Dateien und Verzeichnisse ebenfalls gelistet.
     * @param indentation Eine Zeichenkette, die den ausgegebenen Namen
     *                    vorangestellt wird, um sie einzurücken.
     */
    private static long dir(final File file, final String indentation)
    {
        if (file.isDirectory()) {
            System.out.println("[dir]\t" + indentation + file.getName());
            final File[] files = file.listFiles();
            long size = 0;
            for (final File f : files) {
                size += dir(f, indentation + "    ");
            }
            return size;
        }
        else {
            System.out.println(file.length() + "\t" + indentation + file.getName());
            return file.length();
        }
    }
}
