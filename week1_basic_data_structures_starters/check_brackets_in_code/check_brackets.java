import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;


//< Problem Description >
//        Task. Your friend is making a text editor for programmers. He is currently working on a feature that will
//        find errors in the usage of different types of brackets. Code can contain any brackets from the set
//        []{}(), where the opening brackets are [,{, and ( and the closing brackets corresponding to them
//        are ],}, and ).
//        For convenience, the text editor should not only inform the user that there is an error in the usage
//        of brackets, but also point to the exact place in the code with the problematic bracket. First priority
//        is to find the first unmatched closing bracket which either doesn’t have an opening bracket before it,
//        like ] in ](), or closes the wrong opening bracket, like } in ()[}. If there are no such mistakes, then
//        it should find the first unmatched opening bracket without the corresponding closing bracket after it,
//        like ( in {}([]. If there are no mistakes, text editor should inform the user that the usage of brackets
//        is correct.
//        Apart from the brackets, code can contain big and small latin letters, digits and punctuation marks.
//        More formally, all brackets in the code should be divided into pairs of matching brackets, such that in
//        each pair the opening bracket goes before the closing bracket, and for any two pairs of brackets either
//        one of them is nested inside another one as in (foo[bar]) or they are separate as in f(a,b)-g[c].
//        The bracket [ corresponds to the bracket ], { corresponds to }, and ( corresponds to ).


class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        int ans = -1; //내가 새롭게 추가함
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                opening_brackets_stack.push(new Bracket(next,position));
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if(opening_brackets_stack.isEmpty()||!opening_brackets_stack.peek().Match(next)){
                    ans = position +1;
                    break;
                }
            }
        }

        // Printing answer, write your code here
        if(ans == -1 && opening_brackets_stack.isEmpty())
            System.out.println("Success");
        else if(ans == -1)
            System.out.println(opening_brackets_stack.peek().position+1);
        else
            System.out.println(ans);
    }
}
