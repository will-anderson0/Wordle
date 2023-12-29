import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class Wordle extends JFrame implements ActionListener{
  //(char)num)f words
  String [] words = {"ABUSE",	"ADULT",	"AGENT",	"ANGER",	"APPLE",	"AWARD",	"BASIS",	"BEACH",	"BIRTH",	"BLOCK",	"BLOOD",	"BOARD",	"BRAIN",	"BREAD",	"BREAK",	"BROWN",	"BUYER",	"CAUSE",	"CHAIN",	"CHAIR",	"CHEST",	"CHIEF",	"CHILD",	"CHINA",	"CLAIM",	"CLASS",	"CLOCK",	"COACH",	"COAST",	"COURT",	"COVER",	"CREAM",	"CRIME",	"CROSS",	"CROWD",	"CROWN",	"CYCLE",	"DANCE",	"DEATH",	"DEPTH",	"DOUBT",	"DRAFT",	"DRAMA",	"DREAM",	"DRESS",	"DRINK",	"DRIVE",	"EARTH",	"ENEMY",	"ENTRY",	"ERROR",	"EVENT",	"FAITH",	"FAULT",	"FIELD",	"FIGHT",	"FINAL",	"FLOOR",	"FOCUS",	"FORCE",	"FRAME",	"FRANK",	"FRONT",	"FRUIT",	"GLASS",	"GRANT",	"GRASS",	"GREEN",	"GROUP",	"GUIDE",	"HEART",	"HENRY",	"HORSE",	"HOTEL",	"HOUSE",	"IMAGE",	"INDEX",	"INPUT",	"ISSUE",	"JAPAN",	"JONES",	"JUDGE",	"KNIFE",	"LAURA",	"LAYER",	"LEVEL",	"LEWIS",	"LIGHT",	"LIMIT",	"LUNCH", "MAJOR",	"MARCH",	"MATCH",	"METAL",	"MODEL",	"MONEY",	"MONTH",	"MOTOR",	"MOUTH",	"MUSIC",	"NIGHT",	"NOISE",	"NORTH",	"NOVEL",	"NURSE",	"OFFER",	"ORDER",	"OTHER",	"OWNER",	"PANEL",	"PAPER",	"PARTY",	"PEACE",	"PETER",	"PHASE",	"PHONE",	"PIECE",	"PILOT",	"PITCH",	"PLACE",	"PLANE",	"PLANT",	"PLATE",	"POINT",	"POUND",	"POWER",	"PRESS",	"PRICE",	"PRIDE",	"PRIZE",	"PROOF",	"QUEEN",	"RADIO",	"RANGE",	"RATIO",	"REPLY",	"RIGHT",	"RIVER",	"ROUND",	"ROUTE",	"RUGBY",	"SCALE",	"SCENE",	"SCOPE",	"SCORE",	"SENSE",	"SHAPE",	"SHARE",	"SHEEP",	"SHEET",	"SHIFT",	"SHIRT",	"SHOCK",	"SIGHT",	"SIMON",	"SKILL",	"SLEEP",	"SMILE",	"SMITH",	"SMOKE",	"SOUND",	"SOUTH",	"SPACE",	"SPEED",	"SPITE",	"SPORT",	"SQUAD",	"STAFF",	"STAGE",	"START",	"STATE",	"STEAM",	"STEEL",	"STOCK",	"STONE",	"STORE",	"STUDY",	"STUFF",	"STYLE",	"SUGAR",	"TABLE",	"TASTE",	"TERRY",	"THEME",	"THING",	"TITLE",	"TOTAL",	"TOUCH",	"TOWER",	"TRACK",	"TRADE",	"TRAIN",	"TREND",	"TRIAL",	"TRUST",	"TRUTH",	"UNCLE",	"UNION",	"UNITY",	"VALUE",	"VIDEO",	"VISIT",	"VOICE",	"WASTE",	"WATCH",	"WATER",	"WHILE",	"WHITE",	"WHOLE",	"WOMAN",	"WORLD",	"YOUTH",	"ALCON",	"AUGHT",	"HELLA",	"ONE’S",	"OUGHT",	"THAME",	"THERE",	"THINE",	"THINE",	"WHERE",	"WHICH",	"WHOSE",	"WHOSO",	"YOURS",	"YOURS",	"ADMIT",	"ADOPT",	"AGREE",	"ALLOW",	"ALTER",	"APPLY",	"ARGUE",	"ARISE",	"AVOID",	"BEGIN",	"BLAME",	"BREAK",	"BRING",	"BUILD",	"BURST",	"CARRY",	"CATCH",	"CAUSE",	"CHECK",	"CLAIM",	"CLEAN",	"CLEAR",	"CLIMB",	"CLOSE",	"COUNT",	"COVER",	"CROSS",	"DANCE",	"DOUBT",	"DRINK",	"DRIVE",	"ENJOY",	"ENTER",	"EXIST",	"FIGHT",	"FOCUS",	"FORCE",	"GUESS",	"IMPLY",	"ISSUE",	"JUDGE",	"LAUGH",	"LEARN",	"LEAVE",	"LET’S",	"LIMIT",	"MARRY",	"MATCH",	"OCCUR",	"OFFER",	"ORDER",	"PHONE",	"PLACE",	"POINT",	"PRESS",	"PROVE",	"RAISE",	"REACH",	"REFER",	"RELAX",	"SERVE",	"SHALL",	"SHARE",	"SHIFT",	"SHOOT",	"SLEEP",	"SOLVE",	"SOUND",	"SPEAK",	"SPEND",	"SPLIT",	"STAND",	"START",	"STATE",	"STICK",	"STUDY",	"TEACH",	"THANK",	"THINK",	"THROW",	"TOUCH",	"TRAIN",	"TREAT",	"TRUST",	"VISIT",	"VOICE",	"WASTE",	"WATCH",	"WORRY",	"WOULD",	"WRITE",	"ABOVE",	"ACUTE",	"ALIVE",	"ALONE",	"ANGRY",	"AWARE",	"AWFUL",	"BASIC",	"BLACK",	"BLIND",	"BRAVE",	"BRIEF",	"BROAD",	"BROWN",	"CHEAP",	"CHIEF",	"CIVIL",	"CLEAN",	"CLEAR",	"CLOSE",	"CRAZY",	"DAILY",	"DIRTY",	"EARLY",	"EMPTY",	"EQUAL",	"EXACT",	"EXTRA",	"FAINT",	"FALSE",	"FIFTH",	"FINAL",	"FIRST",	"FRESH",	"FRONT",	"FUNNY",	"GIANT",	"GRAND",	"GREAT",	"GREEN",	"GROSS",	"HAPPY",	"HARSH",	"HEAVY",	"HUMAN",	"IDEAL",	"INNER",	"JOINT",	"LARGE",	"LEGAL",	"LEVEL",	"LIGHT",	"LOCAL",	"LOOSE",	"LUCKY",	"MAGIC",	"MAJOR",	"MINOR",	"MORAL",	"NAKED",	"NASTY",	"NAVAL",	"OTHER",	"OUTER",	"PLAIN",	"PRIME",	"PRIOR",	"PROUD",	"QUICK",	"QUIET",	"RAPID",	"READY",	"RIGHT",	"ROMAN",	"ROUGH",	"ROUND",	"ROYAL",	"RURAL",	"SHARP",	"SHEER",	"SHORT",	"SILLY",	"SIXTH",	"SMALL",	"SMART",	"SOLID",	"SORRY",	"SPARE",	"STEEP",	"STILL",	"SUPER",	"SWEET",	"THICK",	"THIRD",	"TIGHT",	"TOTAL",	"TOUGH",	"UPPER",	"UPSET",	"URBAN",	"USUAL",	"VAGUE",	"VALID",	"VITAL",	"WHITE",	"WHOLE",	"WRONG",	"YOUNG",	"AFORE",	"AFTER",	"BOTHE",	"OTHER",	"SINCE",	"SLASH",	"UNTIL",	"WHERE",	"WHILE",	"ABACK",	"ABAFT",	"ABOON",	"ABOUT",	"ABOVE",	"ACCEL",	"ADOWN",	"AFOOT",	"AFORE",	"AFOUL",	"AFTER",	"AGAIN",	"AGAPE",	"AGOGO",	"AGONE",	"AHEAD",	"AHULL",	"ALIFE",	"ALIKE",	"ALINE",	"ALOFT",	"ALONE",	"ALONG",	"ALOOF",	"ALOUD",	"AMISS",	"AMPLY",	"AMUCK",	"APACE",	"APART",	"APTLY",	"AREAR",	"ASIDE",	"ASKEW",	"AWFUL",	"BADLY",	"BALLY",	"BELOW",	"CANNY",	"CHEAP",	"CLEAN",	"CLEAR",	"COYLY",	"DAILY",	"DIMLY",	"DIRTY",	"DITTO",	"DRILY",	"DRYLY",	"DULLY",	"EARLY",	"EXTRA",	"FALSE",	"FATLY",	"FEYLY",	"FIRST",	"FITLY",	"FORTE",	"FORTH",	"FRESH",	"FULLY",	"FUNNY",	"GAILY",	"GAYLY",	"GODLY",	"GREAT",	"HAPLY",	"HEAVY",	"HELLA",	"HENCE",	"HOTLY",	"ICILY",	"INFRA",	"INTL.",	"JILDI",	"JOLLY",	"LAXLY",	"LENTO",	"LIGHT",	"LOWLY",	"MADLY",	"MAYBE",	"NEVER",	"NEWLY",	"NOBLY",	"ODDLY",	"OFTEN",	"OTHER",	"OUGHT",	"PARTY",	"PIANO",	"PLAIN",	"PLONK",	"PLUMB",	"PRIOR",	"QUEER",	"QUICK",	"QUITE",	"RAMEN",	"RAPID",	"REDLY",	"RIGHT",	"ROUGH",	"ROUND",	"SADLY",	"SECUS",	"SELLY",	"SHARP",	"SHEER",	"SHILY",	"SHORT",	"SHYLY",	"SILLY",	"SINCE",	"SLEEK",	"SLYLY",	"SMALL",	"SO-SO",	"SOUND",	"SPANG",	"SRSLY",	"STARK",	"STILL",	"STONE",	"STOUR",	"SUPER",	"TALLY",	"TANTO",	"THERE",	"THICK",	"TIGHT",	"TODAY",	"TOMOZ",	"TRULY",	"TWICE",	"UNDER",	"UTTER",	"VERRY",	"WANLY",	"WETLY",	"WHERE",	"WRONG",	"WRYLY",	"ABAFT",	"ABOON",	"ABOUT",	"ABOVE",	"ADOWN",	"AFORE",	"AFTER",	"ALONG",	"ALOOF",	"AMONG",	"BELOW",	"CIRCA",	"CROSS",	"FURTH",	"MINUS",	"NEATH",	"ROUND",	"SINCE",	"SPITE",	"UNDER",	"UNTIL",	"AARGH",	"ADIEU",	"ADIOS",	"ALACK",	"ALOHA",	"AVAST",	"BAKAW",	"BASTA",	"BEGAD",	"BLESS",	"BLIGE",	"BRAVA",	"BRAVO",	"BRING",	"CHOOK",	"DAMME",	"DILDO",	"DITTO",	"FRICK",	"FUDGE",	"GOLLY",	"GRATZ",	"HALLO",	"HASTA",	"HAVOC",	"HELLA",	"HELLO",	"HOWAY",	"HOWDY",	"HULLO",	"HUZZA",	"JESUS",	"KAPOW",	"LOOSE",	"LORDY",	"MARRY",	"MERCY",	"NIGHT",	"PLONK",	"PSYCH",	"QUITE",	"SALVE",	"SKOAL",	"SNIFF",	"SOOEY",	"THERE",	"THIAM",	"THWAP",	"TOUGH",	"TWIRP",	"VIOLA",	"VIVAT",	"WACKO",	"WAHEY",	"WHIST",	"WILMA",	"WIRRA",	"WOOPS",	"WOWIE",	"YECCH",	"YEEHA",	"YEESH",	"YOWCH"};
  JLabel [][] outline = new JLabel [6][6];
  JButton [] arr = {new JButton("A"), new JButton("B"), new JButton("C"), new JButton("D"), new JButton("E"), new JButton("F"), new JButton("G"), new JButton("H"), new JButton("I"), new JButton("J"), new JButton("K"), new JButton("L"), new JButton("M"), new JButton("N"),new JButton("O"), new JButton("P"), new JButton("Q"), new JButton("R"), new JButton("S"), new JButton("T"), new JButton("U"), new JButton("V"), new JButton("W"), new JButton("X"), new JButton("Y"), new JButton("Z")};

  //border
  Border blackline = BorderFactory.createLineBorder(Color.black);

  //Jbuttons(keyboard)
  JButton enter = new JButton("Enter");
  JButton backspace = new JButton("Backspace");
  JLabel invisible = new JLabel();
  

  //JPanels
  JPanel northPnl = new JPanel();
  JPanel centerPnl = new JPanel();
  JPanel southPnl = new JPanel();

  //label
  JLabel title = new JLabel("WORDLE");

  String realWord = words[(int)(Math.random()*words.length)];
  String createdWord = "";

  int x = 0;
  boolean test = true;
  

  public Wordle(){
    //super("Wordle");
    setSize(500, 350);

    //north panel
    northPnl.add(title);
    add(northPnl, BorderLayout.NORTH);

    //center panel
    centerPnl.setLayout(new GridLayout(6, 6));

    makeLetterBoxes();

    add(centerPnl, BorderLayout.CENTER);
    


    //south panel
    southPnl.setLayout(new GridLayout(3,10));
    southPnl.add(arr[16]); //q
    southPnl.add(arr[22]); //w
    southPnl.add(arr[4]); //e
    southPnl.add(arr[17]); //r
    southPnl.add(arr[19]); //t
    southPnl.add(arr[24]); //y
    southPnl.add(arr[20]); //u
    southPnl.add(arr[8]); //i
    southPnl.add(arr[14]); //o
    southPnl.add(arr[15]); //p
    southPnl.add(arr[0]); //a
    southPnl.add(arr[18]); //s
    southPnl.add(arr[3]); //d
    southPnl.add(arr[5]); //f
    southPnl.add(arr[6]); //g
    southPnl.add(arr[7]); //h
    southPnl.add(arr[9]); //j
    southPnl.add(arr[10]); //k
    southPnl.add(arr[11]); //l
    southPnl.add(invisible);
    southPnl.add(enter);
    enter.addActionListener(this);
    southPnl.add(arr[25]); //z
    southPnl.add(arr[23]); //x
    southPnl.add(arr[2]); //c
    southPnl.add(arr[21]); //v
    southPnl.add(arr[1]); //b
    southPnl.add(arr[13]); //n
    southPnl.add(arr[12]); //m
    southPnl.add(backspace);
    backspace.addActionListener(this);
    for(int i = 0; i<26; i++){
      arr[i].addActionListener(this);
    }
    add(southPnl, BorderLayout.SOUTH);


    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public void makeLetterBoxes(){
    for(int r = 0; r< outline.length; r++){
      for(int c = 0; c<outline[0].length; c++){
          outline[r][c] = new JLabel("");
          centerPnl.add(outline[r][c]);
          outline[r][c].setBorder(blackline);
          outline[r][c].setHorizontalAlignment(JLabel.CENTER);
          outline[r][c].setOpaque(true);
        
      }
    }
    for(int i = 0; i<outline.length; i++){
      outline[i][outline.length-1].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
  }

  public void actionPerformed(ActionEvent e){
    Object source = e.getSource();
    
    System.out.println(realWord);

      for(int i = 0; i<arr.length; i++){
            
        if(source == arr[i]){
          if(createdWord.length() < 5){
            createdWord += arr[i].getText();
              for(int y = 0; y<createdWord.length(); y++){
                outline[x][y].setText(createdWord.substring(y,y+1));
    
              }
            System.out.println(createdWord);
            
          }
        }
      }
  
      if(source == backspace){
        if(createdWord.length() == 1){
          outline[x][0].setText("");
          createdWord = "";
        }else if(createdWord.length() == 2){
          outline[x][1].setText("");
          createdWord = createdWord.substring(0,1);
        }else if(createdWord.length() == 3){
          outline[x][2].setText("");
          createdWord = createdWord.substring(0,2);
        }else if(createdWord.length() == 4){
          outline[x][3].setText("");
          createdWord = createdWord.substring(0,3);
        }else if(createdWord.length() == 5){
          outline[x][4].setText("");
          createdWord = createdWord.substring(0,4);
        }
      }
      
  
      if(source == enter && createdWord.length() == 5){
        if(createdWord.equals(realWord)){
          for(int r = 0; r< outline.length; r++){
            for(int c = 0; c<outline[0].length; c++){
              //centerPnl.remove(outline[r][c]);
              
              outline[r][c].setText("");
              outline[r][c].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
              outline[r][c].setBackground(Color.GREEN);
              centerPnl.setBackground(Color.GREEN);
              //outline[r][c].setOpaque(true);
              test = false;
              

            }
          }
          for(int i = 0; i<26; i++){
            southPnl.remove(arr[i]);
          }
          southPnl.remove(invisible);
          southPnl.remove(enter);
          southPnl.remove(backspace);
          northPnl.setBackground(Color.GREEN);
          title.setText("Congrats, you got the word "+ realWord +"!");
        }

        
        System.out.println(realWord);
        System.out.println(x);
        if(test == true){
          for(int i = 0; i<realWord.length(); i++){
              if(outline[x][i].getText().equals(realWord.substring(i,i+1))){
                outline[x][i].setBackground(Color.GREEN);
                for(int v = 0; v<arr.length; v++){
                  if(outline[x][i].getBackground() == Color.GREEN && outline[x][i].getText().equals(arr[v].getText())){
                    arr[v].setBackground(Color.GREEN);
                  }
                }
              }else if(realWord.contains(outline[x][i].getText()) && !(outline[x][i].getText().equals(realWord.substring(i,i+1)))){
                outline[x][i].setBackground(Color.YELLOW);
                for(int v = 0; v<arr.length; v++){
                  if(outline[x][i].getBackground() == Color.YELLOW && outline[x][i].getText().equals(arr[v].getText())){
                    arr[v].setBackground(Color.YELLOW);
                  }
                }   
              }else{
                outline[x][i].setBackground(Color.WHITE);
                for(int v = 0; v<arr.length; v++){
                  if(outline[x][i].getBackground() == Color.WHITE && outline[x][i].getText().equals(arr[v].getText())){
                    arr[v].setEnabled(false);
                  }
                } 
              }
          }
          
        x++;
        System.out.println(x);
        createdWord = "";
  
        }
      }    
  }

  public static void main(String [] args){
    
  }
}