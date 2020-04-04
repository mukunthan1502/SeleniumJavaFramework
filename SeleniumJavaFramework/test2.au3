Run("notepad.exe")

WinWaitActive("Untitled - Notepad")

Send("Typing in the notepad")

WinClose("*Untitled - Notepad")

WinWaitActive("Notepad","Save")

Send("{ENTER}")

WinWaitActive("Save As","Text")

Send("Myfirstfile.txt")

Send("{ENTER}")

WinWaitActive("Confirm Save As","Yes")

Send("{LEFT}")

Send("{ENTER}")



