package ru.vsu.cs.course1;

import org.apache.commons.cli.*;
import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.SwingUtils;

import java.io.PrintStream;
import java.util.List;
import java.util.Locale;


/**
 * Демонстрируется работа с библиотекой apache commons-cli
 *
 * @see <a href="https://urvanov.ru/2019/06/08/apache-commons-cli/">Apache Commons CLI</a>
 * @see <a href="https://coderlessons.com/tutorials/java-tekhnologii/izuchite-apache-commons-cli/apache-commons-cli-kratkoe-rukovodstvo">Apache Commons CLI — Краткое руководство</a>
 */
public class Program {
    public static final String PROGRAM_NAME_IN_HELP = "program (-h | -w | (-r | -c) -i <in-file> [-o <out-file>])";

    public static void winMain() throws Exception {
        //SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        Options cmdLineOptions = new Options();
        cmdLineOptions.addOption("r", "reverse-rows", false, "Reverse rows");
        cmdLineOptions.addOption("c", "reverse-columns", false, "Reverse columns");
        cmdLineOptions.addOption("h", "help", false, "Show help");
        cmdLineOptions.addOption("w", "window", false, "Use window user interface");
        cmdLineOptions.addOption("i", "input-file", true, "Input file");
        cmdLineOptions.addOption("o", "output-file", true, "Output file");
        cmdLineOptions.addOption("n", "output-file", true, "N");
        cmdLineOptions.addOption("x", "output-file", true, "X");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmdLine = null;
        try {
            cmdLine = parser.parse(cmdLineOptions, args);
        } catch (Exception e) {
            new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
            System.exit(1);
        }

        if (cmdLine.hasOption("h")) {
            new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
            System.exit(1);
        }
        if (cmdLine.hasOption("w")) {
            winMain();
        } else if(cmdLine.hasOption("i")) {
            String inputFilename = cmdLine.getOptionValue("i");
            int X = cmdLine.hasOption("x") ? Integer.parseInt(cmdLine.getOptionValue("x")):0;
            int N = cmdLine.hasOption("n") ? Integer.parseInt(cmdLine.getOptionValue("n")):0;
            List<Student> students = Solution.solution(ConsoleStudents.fileToList(inputFilename),N,X);
            for (Student student : students) {
                System.out.println(student.toString());
            }

            if (cmdLine.hasOption("o")){
                PrintStream out = new PrintStream(cmdLine.getOptionValue("o"));
                for(Student student : students) {
                    out.println(student.toString());
                }
                out.close();
            }
        }
    }
}
