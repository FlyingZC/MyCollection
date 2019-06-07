package com.zc;

public class Person implements Comparable<Person>
{
    private String name;

    private int age;

    private String sex;

    public Person(String name, int age)
    {
        super();
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String sex)
    {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person()
    {
        super();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (name == null)
        {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        return true;
    }
	
	@Override
    public int compareTo(Person o) {
        return this.getAge() - o.getAge();
    }

}
