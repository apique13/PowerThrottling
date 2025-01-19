# PowerThrottling
An eclipse plugin used to disable power throttling in Eclipse on Windows

# What it is supposed to do ?
I developed this plugin for Eclipse because, sometimes, for reasons decided by the system, I found Eclipse compiling my workspace using only the 4 E-cores of my processor while the P-cores were available.
The purpose of the plugin is to use JNA to call the SetProcessInformation (https://learn.microsoft.com/en-us/windows/win32/api/processthreadsapi/nf-processthreadsapi-setprocessinformation) method disable Power Throttling for Eclipse.
Power Throttling may happened when you are opening a browser while Eclipse is working in background.
![image](https://github.com/user-attachments/assets/6b57fc92-188d-4f9a-9365-5a4536428f7f)

# Options
Activate Performances in Preferences-> PowerThrottling Preferences to disable Power Throttling.
(Performances is activated by default if the plugin is loaded)
![image](https://github.com/user-attachments/assets/96babbf5-a103-4239-b0f6-6f77d6ce6932)
