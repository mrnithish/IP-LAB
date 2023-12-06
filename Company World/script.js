function showInformation(branchName) {
    var infoTitle = document.getElementById('info-title');
    var infoText = document.getElementById('info-text');

    // Replace with actual information for each branch
    var branchInformation = getBranchInformation(branchName);

    infoTitle.textContent = branchInformation.title;
    infoText.textContent = branchInformation.description;
}



function getBranchInformation(branchName) {
    // Replace with actual data for each branch
    if (branchName === 'Branch 1') {
        return {
            title: 'Branch 1 Information',
            description: 'Details about Branch 1.'
        };
    } else if (branchName === 'Branch 2') {
        return {
            title: 'Branch 2 Information',
            description: 'Details about Branch 2.'
        };
    } else if (branchName === 'Branch 3') {
        return {
            title: 'Branch 3 Information',
            description: 'Details about Branch 3.'
        };
    } else if (branchName === 'Branch 4') {
        return {
            title: 'Branch 4 Information',
            description: 'Details about Branch 4.'
        };
    }

    // Add more branches as needed
}


