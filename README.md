

# 🕵️ Decryption Lab: Malware, Obfuscation, and Reflection

## 🔍 Overview

In this lab, you'll explore how malicious software can disguise its true purpose using two powerful Java features: **obfuscation** and **reflection**.  Understanding these concepts are important for you as a future developer.  It will help you to engineer better and more aware products.  In addition, it might just help you out during an interview.

Here is the setup.  Attackers frequently use these techniques to make their programs harder to understand, analyze, and detect. In this hands-on exercise, you’ll act like a reverse engineer, digging into a mysterious Java program where source code isn't available—only `.class` files are provided.

Your mission is to **uncover encrypted messages** and **analyze hidden behaviors** using Java reflection. It’s a safe and legal simulation of the techniques used by malware researchers and ethical hackers.

---

## What Is Java Reflection?

**Reflection** is a powerful feature in Java that allows a program to examine and manipulate its own structure—**at runtime**. This means your code can dynamically:

- Inspect classes, methods, and fields
- Instantiate new objects
- Call methods—even private ones!
- Modify field values

Note, nearly all languages have something similar to Java reflection.  The capability is present, for example, in Python.  There it is called introspection and dynamic attribute access.

### 🛠 Example: Why Reflection Is Dangerous in Malware

Malware authors love reflection because:

- It allows them to **hide what code is being executed**.
- They can avoid static detection by tools that scan for known method names or strings.
- They can **dynamically load behavior** from encrypted or obfuscated sources.

In this lab, reflection is used to hide both the method names being executed and the encrypted content they return. You'll use reflection to **uncover these hidden behaviors.**

---

## 🧪 Part 1: Cracking the Mystery Toolbox

You're given a compiled Java class file: `MysteryToolbox.class`. It contains several **encrypted messages**, each stored in a method named after a tool. The catch? You can’t see the source—only the bytecode!

You are given the class ```Reflector.java```.  Your instrucotr will step you through what it does.  Its a gentle introduction into how reflection works. 

You're also given a partially complete helper program: `DecryptionLab.java`, which reflects on the methods of `MysteryToolbox` and provides the correct decryption keys.

### 🧰 Task 1

- Use **reflection** to invoke each method with the correct decryption key.
- Print out the decrypted message for each tool.
- There is a Word document on the D2L module page for this lab, fill in the messages for each of the tools (they are the decrypted strings).  Also, in the space provided include the code you wrote for the TODO section.
- There are **four tools** (methods) to check:
  - `hammer`
  - `screwdriver`
  - `wrench`
  - `glue`

These methods each take a `String` key and return a decrypted `String` message. Here's an example of one method's structure (from the `.class` file):

```java
public String glue(String key) {
    return decrypt("bRoeTQc7+oFAS7F7o4/7nJuirwRlsgkIi4NCeJ5xjJsS0udTbyuM7vUWSNtZKVvt", key);
}
```

You'll complete the `TODO` in the provided `DecryptionLab.java` to reflectively invoke these methods and uncover the messages.  Note, even this small example above of an encrypted string leads you down the path of malware and analystis and thinking; why would someone encrypt a string?  What information does it contain they wished to hide?



---

## 💣 Part 2: The Student Gadget

Next, you’ll explore a second compiled class: `StudentGadget.class`. This one behaves more like an actual malware sample: it contains an **encrypted command string**, which is **decrypted at runtime** using a secret key, and then **executed** using Java’s `Runtime.exec()`.

### Task 2

- Write Java code that instantiates (or runs) `StudentGadget` and calls its `launch()` method.
- Pass in the key as an argument to `launch()`: `U9r1IESzvyqFiLpQ`
- Observe what happens.

This simulates how malware might decrypt and execute a payload **only when certain conditions are met**, like having the correct key or environment.

⚠️ **Note:** The program simulates a shell command being run using `/bin/sh -c`. It won't do anything malicious, but it's important to understand how dangerous this behavior is in a real-world setting.

Record what the application does in Word document.

Once complete, submit the document to D2L for your lab submission.

