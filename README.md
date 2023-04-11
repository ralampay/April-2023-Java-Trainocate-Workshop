# April Java Training Workshop Trainocate

## Basic Git Commands

### Initialize a local directory as a git repository 

```
git init
```

### Add a Remote Reference for this projec

```
git remote add [name_of_reference (i.e. origin)] [url (i.e. from github)]
```

### Committing Files to Remote Repository

1. Add changes to our staging area

```
git add --all
```

2. Create a commit. Every commit will have a commit hash

```
git commit -m "Added stuff to README.md"
```

3. Push those changes to the remote repository

```
git push origin master
```

### Cloning a Repository

```
git clone git@github.com:ralampay/April-2023-Java-Trainocate-Workshop.git
```

### Pull Changes

```
git pull origin master
```