# Java Project 2025

This repository is intended for storing and managing the Java project.

## Setting up a Git repository via the Linux Terminal

If you are using a Linux operating system, you can use Git to manage your projects and interact with this repository. Here are the basic steps:

### Step 1: Install Git (if not already installed)

Make sure Git is installed on your system. If it's not installed, you can install it using your package manager. For example, if you are using Ubuntu or Debian, you can use the following command:

```bash
sudo apt-get install git
```

### Step 2: Configure Git

Configure Git with your GitHub username and email address:

```bash
git config --global user.name "Your GitHub Username"
git config --global user.email "your.email@example.com"
```
#### Credential Storage (Temporary Solution)
If you need to quickly avoid re-entering your credentials and understand the security implications, you can use the following command to store your credentials:

```bash
git config --global credential.helper store
```
Please note: This stores your credentials unencrypted on disk and is considered a security risk. It's intended as a temporary solution. Use more secure methods like SSH keys for long-term projects.

### Step 3: Clone the repository

To clone this repository, navigate to the directory where you want to store it and execute the following command:

```bash
git clone https://github.com/your-username/university-assignments-repository.git
```

### Step 4: Create and Switch Branches

To create a new branch for your work, use the following command:

```bash
git checkout -b your-branch-name
```

You can now make changes to your assignments within this branch.

To switch to an existing branch, use the following command:

```bash
git checkout existing-branch-name
```

### Step 5: Commit changes

Execute the following command to commit the changes you've made to your local repository:

```bash
git add .
git commit -m "A meaningful commit message here"
```

### Step 6: Push changes

To upload your changes to this GitHub repository on your branch, use the following command:

```bash
git push origin your-branch-name
```

## Step 7: Set up SSH Keys

To avoid being prompted for login credentials every time you push changes, it's recommended to set up SSH keys for secure authentication. Follow the GitHub documentation to generate and add an SSH key to your GitHub account: [Adding a new SSH key to your GitHub account](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account).

Once your SSH key is set up, Git will use it for authentication, and you won't need to enter your username and password each time you push changes.

<details>
  <summary>Show More Details</summary>
  
  If you want to learn the exact steps for setting up SSH keys, follow these steps:

  1. Open the [GitHub documentation](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account).
  2. Follow the instructions to generate an SSH key.
  3. Add the generated public key to your GitHub account.

  Once you've completed these steps, your repository should work without repeatedly requesting login credentials when you upload changes.
</details>

This Markdown content provides instructions in English and uses a collapsible section `<details>` to display additional details if the user chooses to expand it.

### Step 8: Pull changes

To retrieve changes made by others from the remote repository to your local repository, use the following command:

```bash
git pull origin your-branch-name
```

Your changes should now be safely stored in this repository without the need for manual login.
