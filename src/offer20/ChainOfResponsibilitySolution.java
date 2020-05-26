package offer20;

import java.util.ArrayList;

public class ChainOfResponsibilitySolution {
    //每个类都实现这个接口
    interface NumberValidate {
        boolean validate(String s);
    }
    //定义一个抽象类，用来检查一些基础的操作，是否为空，去掉首尾空格，去掉 +/-
//doValidate 交给子类自己去实现
    abstract class  NumberValidateTemplate implements NumberValidate{

        public boolean validate(String s)
        {
            if (checkStringEmpty(s))
            {
                return false;
            }

            s = checkAndProcessHeader(s);

            if (s.length() == 0)
            {
                return false;
            }

            return doValidate(s);
        }

        private boolean checkStringEmpty(String s)
        {
            if (s.equals(""))
            {
                return true;
            }

            return false;
        }

        private String checkAndProcessHeader(String value)
        {
            value = value.trim();

            if (value.startsWith("+") || value.startsWith("-"))
            {
                value = value.substring(1);
            }


            return value;
        }



        protected abstract boolean doValidate(String s);
    }

    //实现 doValidate 判断是否是整数
    class IntegerValidate extends NumberValidateTemplate{

        protected boolean doValidate(String integer)
        {
            for (int i = 0; i < integer.length(); i++)
            {
                if(Character.isDigit(integer.charAt(i)) == false)
                {
                    return false;
                }
            }

            return true;
        }
    }

    //实现 doValidate 判断是否是科学计数法
    class SienceFormatValidate extends NumberValidateTemplate{

        protected boolean doValidate(String s)
        {
            s = s.toLowerCase();
            int pos = s.indexOf("e");
            if (pos == -1)
            {
                return false;
            }

            if (s.length() == 1)
            {
                return false;
            }

            String first = s.substring(0, pos);
            String second = s.substring(pos+1, s.length());

            if (validatePartBeforeE(first) == false || validatePartAfterE(second) == false)
            {
                return false;
            }


            return true;
        }

        private boolean validatePartBeforeE(String first)
        {
            if (first.equals("") == true)
            {
                return false;
            }

            if (checkHeadAndEndForSpace(first) == false)
            {
                return false;
            }

            NumberValidate integerValidate = new IntegerValidate();
            NumberValidate floatValidate = new FloatValidate();
            if (integerValidate.validate(first) == false && floatValidate.validate(first) == false)
            {
                return false;
            }

            return true;
        }

        private boolean checkHeadAndEndForSpace(String part)
        {

            if (part.startsWith(" ") ||
                    part.endsWith(" "))
            {
                return false;
            }

            return true;
        }

        private boolean validatePartAfterE(String second)
        {
            if (second.equals("") == true)
            {
                return false;
            }

            if (checkHeadAndEndForSpace(second) == false)
            {
                return false;
            }

            NumberValidate integerValidate = new IntegerValidate();
            if (integerValidate.validate(second) == false)
            {
                return false;
            }

            return true;
        }
    }
    //实现 doValidate 判断是否是小数
    class FloatValidate extends NumberValidateTemplate{

        protected boolean doValidate(String floatVal)
        {
            int pos = floatVal.indexOf(".");
            if (pos == -1)
            {
                return false;
            }

            if (floatVal.length() == 1)
            {
                return false;
            }

            NumberValidate nv = new IntegerValidate();
            String first = floatVal.substring(0, pos);
            String second = floatVal.substring(pos + 1, floatVal.length());

            if (checkFirstPart(first) == true && checkFirstPart(second) == true)
            {
                return true;
            }

            return false;
        }

        private boolean checkFirstPart(String first)
        {
            if (first.equals("") == false && checkPart(first) == false)
            {
                return false;
            }

            return true;
        }

        private boolean checkPart(String part)
        {
            if (Character.isDigit(part.charAt(0)) == false ||
                    Character.isDigit(part.charAt(part.length() - 1)) == false)
            {
                return false;
            }

            NumberValidate nv = new IntegerValidate();
            if (nv.validate(part) == false)
            {
                return false;
            }

            return true;
        }
    }
    //定义一个执行者，我们把之前实现的各个类加到一个数组里，然后依次调用
    class NumberValidator implements NumberValidate {

        private ArrayList<NumberValidate> validators = new ArrayList<NumberValidate>();

        public NumberValidator()
        {
            addValidators();
        }

        private  void addValidators()
        {
            NumberValidate nv = new IntegerValidate();
            validators.add(nv);

            nv = new FloatValidate();
            validators.add(nv);

            //nv = new HexValidate();
            //validators.add(nv);

            nv = new SienceFormatValidate();
            validators.add(nv);
        }

        @Override
        public boolean validate(String s)
        {
            for (NumberValidate nv : validators)
            {
                if (nv.validate(s) == true)
                {
                    return true;
                }
            }

            return false;
        }


    }
    public boolean isNumber(String s) {
        NumberValidate nv = new NumberValidator();
        return nv.validate(s);
    }
}
